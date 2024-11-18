package behaviours;

import java.util.concurrent.CompletableFuture;

import models.WeatherData;

public interface IWeatherService {
    CompletableFuture<WeatherData> getWeatherData() throws Exception;
}
