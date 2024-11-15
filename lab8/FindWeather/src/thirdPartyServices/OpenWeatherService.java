package thirdPartyServices;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;

import behaviours.IWeatherService;
import models.WeatherData;

public class OpenWeatherService implements IWeatherService {
    private final String OPEN_WEATHER_MAP_API_KEY = "e3c9bf35e426c1789775f45994cc305c";
    private LocationService locationService = new LocationService();

    @Override
    public WeatherData getWeatherData() throws Exception {
        String URL = MessageFormat.format(
                "https://api.openweathermap.org/data/2.5/weather?lat={0}&lon={1}&units=metric&appid={2}",
                locationService.getLat(), locationService.getLon(), OPEN_WEATHER_MAP_API_KEY);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        String jsonResponse = response.body();

        // {"coord":{"lon":90.4023,"lat":23.8915},"weather":[{"id":721,"main":"Haze","description":"haze","icon":"50n"}],"base":"stations","main":{"temp":25,"feels_like":25.36,"temp_min":25,"temp_max":25,"pressure":1012,"humidity":69,"sea_level":1012,"grnd_level":1011},"visibility":3200,"wind":{"speed":1.54,"deg":260},"clouds":{"all":40},"dt":1731685022,"sys":{"type":1,"id":9145,"country":"BD","sunrise":1731629603,"sunset":1731669170},"timezone":21600,"id":1185098,"name":"Tongi","cod":200}

        String location = jsonResponse.split("\"name\":")[1].split(",")[0].replace("\"", "");
        double temperature = Double.parseDouble(jsonResponse.split("\"temp\":")[1].split(",")[0]);
        String weatherDescription = jsonResponse.split("\"description\":")[1].split(",")[0].replace("\"", "");

        System.out.println("Location: " + location);
        System.out.println("Temperature: " + temperature);
        System.out.println("Weather Description: " + weatherDescription);

        return new WeatherData(temperature, weatherDescription, location, "OpenWeatherMap");
    }
}
