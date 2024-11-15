package thirdPartyServices;

import behaviours.IWeatherService;
import models.WeatherData;

public class WeatherStackService implements IWeatherService {
    // private static final String API_KEY = "e3c9bf35e426c1789775f45994cc305c";

    @Override
    public WeatherData getWeatherData(String location) throws Exception {

        // Make HTTP req call to real API
        if (location.equalsIgnoreCase("gulshan")) {
            return new WeatherData(30.0, "Clear", location, "WeatherStack");
        } else if (location.equalsIgnoreCase("uttara")) {
            return new WeatherData(25.5, "Sunny", location, "WeatherStack");
        } else {
            return new WeatherData(15.0, "Cloudy", location, "WeatherStack");
        }
    }
}
