package caching_proxy.proxy;

import java.util.Map;

import caching_proxy.WeatherService.RealWeatherService;
import caching_proxy.WeatherService.WeatherService;

import java.util.HashMap;

public class WeatherServiceProxy implements WeatherService {
    private final RealWeatherService realService;
    private final Map<String, String> cache;

    public WeatherServiceProxy() {
        this.realService = new RealWeatherService();
        this.cache = new HashMap<>();
    }

    @Override
    public String getWeather(String city) {
        // Check if we have cached data
        if (cache.containsKey(city)) {
            System.out.println("Returning cached data for: " + city);
            return cache.get(city);
        }

        // No cached data, get from real service
        String weather = realService.getWeather(city);

        // Store in cache
        cache.put(city, weather);

        return weather;
    }

    public void showCache() {
        System.out.println("\n--- Current Cache ---");
        if (cache.isEmpty()) {
            System.out.println("Cache is empty");
        } else {
            for (String city : cache.keySet()) {
                System.out.println("- " + city);
            }
        }
        System.out.println("-------------------\n");
    }
}