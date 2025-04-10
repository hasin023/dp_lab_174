package caching_proxy.WeatherService;

public class RealWeatherService implements WeatherService {
    @Override
    public String getWeather(String city) {
        System.out.println("Making expensive API call for: " + city);

        // Simulate API call delay
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Simple weather data based on city name
        int temp = 15 + (city.length() % 15);
        return city + ": " + temp + "°C, " + (temp > 20 ? "Sunny" : "Cloudy");
    }
}