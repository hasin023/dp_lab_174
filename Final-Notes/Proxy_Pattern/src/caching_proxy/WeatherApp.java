package caching_proxy;

import caching_proxy.proxy.WeatherServiceProxy;

public class WeatherApp {
    public static void main(String[] args) throws Exception {
        WeatherServiceProxy weatherProxy = new WeatherServiceProxy();

        // First requests - will call real service
        System.out.println("--- First request for Paris ---");
        System.out.println(weatherProxy.getWeather("Paris"));

        System.out.println("\n--- First request for Tokyo ---");
        System.out.println(weatherProxy.getWeather("Tokyo"));

        // Show current cache status
        weatherProxy.showCache();

        // Second requests - should use cache
        System.out.println("--- Second request for Paris ---");
        System.out.println(weatherProxy.getWeather("Paris"));

        System.out.println("\n--- First request for New York ---");
        System.out.println(weatherProxy.getWeather("New York"));

        System.out.println("\n--- Second request for Tokyo ---");
        System.out.println(weatherProxy.getWeather("Tokyo"));

        // Final cache status
        weatherProxy.showCache();
    }
}
