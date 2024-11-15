package behaviours;

import models.WeatherData;

public interface IWeatherService {
    WeatherData getWeatherData(String location) throws Exception;
}
