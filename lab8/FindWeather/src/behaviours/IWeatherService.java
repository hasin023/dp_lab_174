package behaviours;

import models.WeatherData;

public interface IWeatherService {
    WeatherData getWeatherData() throws Exception;
}
