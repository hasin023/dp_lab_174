package proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import behaviours.*;
import models.*;
import services.*;

public class WeatherServiceProxy {
    private List<IWeatherService> weatherServices;
    private Map<String, CachedWeatherData> cache;
    private final long CACHE_DURATION = 600000;

    public WeatherServiceProxy() {
        this.weatherServices = new ArrayList<>();
        this.weatherServices.add(new OpenWeatherService());
        this.weatherServices.add(new WeatherStackService());

        this.cache = new HashMap<>();
    }

    public void addWeatherService(IWeatherService service) {
        weatherServices.add(service);
    }

    public WeatherData getWeatherData() throws Exception {
        for (CachedWeatherData cachedData : cache.values()) {
            if (isCacheValid(cachedData)) {
                cachedData.weatherData.updateSource("Cached Data");
                return cachedData.weatherData;
            }
        }

        for (IWeatherService service : weatherServices) {
            try {
                CompletableFuture<WeatherData> dataFuture = service.getWeatherData();
                WeatherData weatherData = dataFuture.get();

                cache.put(weatherData.getLocation(),
                        new CachedWeatherData(weatherData, System.currentTimeMillis()));

                return weatherData;
            } catch (Exception e) {
                System.out.println("Service failed: " + service.getClass().getSimpleName());
            }
        }

        throw new Exception("All weather services failed");
    }

    private boolean isCacheValid(CachedWeatherData cachedData) {
        return System.currentTimeMillis() - cachedData.timestamp < CACHE_DURATION;
    }

    public void resetCache() {
        cache.clear();
    }
}