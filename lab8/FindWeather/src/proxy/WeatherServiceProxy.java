package proxy;

import java.util.HashMap;
import java.util.Map;

import behaviours.IWeatherService;
import models.WeatherData;
import thirdPartyServices.OpenWeatherService;
import thirdPartyServices.WeatherStackService;

public class WeatherServiceProxy {
    private IWeatherService openWeatherService;
    private IWeatherService weatherStackService;
    private Map<String, WeatherData> cache; // Location -> WeatherData

    private final long CACHE_DURATION = 600000; // 10 minutes
    private final int OPENWEATHER_API_LIMIT = 2;
    private int openWeatherRequestCount = 0;

    public WeatherServiceProxy() {
        this.openWeatherService = new OpenWeatherService();
        this.weatherStackService = new WeatherStackService();
        this.cache = new HashMap<>();
    }

    public WeatherData getWeatherData(String location) throws Exception {
        WeatherData cachedData = cache.get(location);

        if (cachedData != null && isCacheValid(cachedData)) {
            cachedData.updateSource("Cached Data");
            return cachedData;
        }

        WeatherData data;
        if (openWeatherRequestCount < OPENWEATHER_API_LIMIT) {
            try {
                data = openWeatherService.getWeatherData(location);
                openWeatherRequestCount++;
                cache.put(location, data);
                return data;
            } catch (Exception e) {
                data = weatherStackService.getWeatherData(location);
                cache.put(location, data);
            }
        } else {
            data = weatherStackService.getWeatherData(location);
            cache.put(location, data);
        }

        return data;
    }

    private boolean isCacheValid(WeatherData data) {
        return System.currentTimeMillis() - data.getTimestamp() < CACHE_DURATION;
    }

    public void showOpenWeatherRequestCount() {
        System.out.println("OpenWeather API requests: " + openWeatherRequestCount);
    }

    public void resetCache() {
        System.out.println("Resetting cache...");
        cache.clear();
    }

    public void resetOpenWatherRequestCount() {
        System.out.println("Resetting OPENWEATHER_API_LIMIT...");
        openWeatherRequestCount = 0;
    }
}
