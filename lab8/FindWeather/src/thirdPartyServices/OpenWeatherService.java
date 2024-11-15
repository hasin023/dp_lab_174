package thirdPartyServices;

import behaviours.IWeatherService;
import models.WeatherData;

public class OpenWeatherService implements IWeatherService {
    private final String OPEN_WEATHER_MAP_API_KEY = "e3c9bf35e426c1789775f45994cc305c";
    private LocationService locationService = new LocationService();

    @Override
    public WeatherData getWeatherData() throws Exception {

        // Make HTTP req call to real API
        if (location.equalsIgnoreCase("dhaka")) {
            return new WeatherData(30.0, "Clear", location, "OpenWeather");
        } else if (location.equalsIgnoreCase("uttara")) {
            return new WeatherData(25.5, "Sunny", location, "OpenWeather");
        } else {
            return new WeatherData(15.0, "Cloudy", location, "OpenWeather");
        }
    }
}
