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

    // private final long CACHE_DURATION = 600000; // 10 minutes

    public WeatherServiceProxy() {
        this.openWeatherService = new OpenWeatherService();
        this.weatherStackService = new WeatherStackService();
        this.cache = new HashMap<>();
    }

    public WeatherData getWeatherData() throws Exception {

        // WeatherData cachedData = cache.get();

        // if (cachedData != null && isCacheValid(cachedData)) {
        // cachedData.updateSource("Cached Data");
        // return cachedData;
        // }

        WeatherData data;
        try {
            data = openWeatherService.getWeatherData();
            // cache.put(location, data);
            return data;
        } catch (Exception e) {
            data = weatherStackService.getWeatherData();
            // cache.put(location, data);
        }

        return data;
    }

    // private boolean isCacheValid(WeatherData data) {
    // return System.currentTimeMillis() - data.getTimestamp() < CACHE_DURATION;
    // }

    public void resetCache() {
        System.out.println("Resetting cache...");
        cache.clear();
    }
}
