package models;

public class CachedWeatherData {
    public WeatherData weatherData;
    public long timestamp;

    public CachedWeatherData(WeatherData weatherData, long timestamp) {
        this.weatherData = weatherData;
        this.timestamp = timestamp;
    }
}
