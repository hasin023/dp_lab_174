package thirdPartyServices;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;

import behaviours.IWeatherService;
import models.WeatherData;

public class WeatherStackService implements IWeatherService {
    private static final String WEATHERSTACK_API_KEY = "b241366e762063ba924efb466bb650d9";
    private LocationService locationService = new LocationService();

    @Override
    public WeatherData getWeatherData() throws Exception {

        String URL = MessageFormat.format(
                "http://api.weatherstack.com/current?access_key={0}&query={1}&units=m",
                WEATHERSTACK_API_KEY, locationService.getCity());

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        String jsonResponse = response.body();

        // {"request":{"type":"City","query":"Tongi,
        // Bangladesh","language":"en","unit":"m"},"location":{"name":"Tongi","country":"Bangladesh","region":"","lat":"23.890","lon":"90.406","timezone_id":"Asia\/Dhaka","localtime":"2024-11-15
        // 20:49","localtime_epoch":1731703740,"utc_offset":"6.0"},"current":{"observation_time":"02:49
        // PM","temperature":24,"weather_code":113,"weather_icons":["https:\/\/cdn.worldweatheronline.com\/images\/wsymbols01_png_64\/wsymbol_0008_clear_sky_night.png"],"weather_descriptions":["Clear
        // "],"wind_speed":12,"wind_degree":330,"wind_dir":"NNW","pressure":1011,"precip":0,"humidity":57,"cloudcover":0,"feelslike":25,"uv_index":0,"visibility":10,"is_day":"no"}}

        String location = jsonResponse.split("\"name\":\"")[1].split("\"")[0];
        double temperature = Double.parseDouble(jsonResponse.split("\"temperature\":")[1].split(",")[0]);
        String weatherDescription = jsonResponse.split("\"weather_descriptions\":\\[\"")[1].split("\"")[0];
        String windSpeed = jsonResponse.split("\"wind_speed\":")[1].split(",")[0];
        String windDirection = jsonResponse.split("\"wind_dir\":\"")[1].split("\"")[0];

        System.out.println("Location: " + location);
        System.out.println("Temperature: " + temperature);
        System.out.println("Weather Description: " + weatherDescription);
        System.out.println("Wind Speed: " + windSpeed);
        System.out.println("Wind Direction: " + windDirection);

        return new WeatherData(temperature, weatherDescription, location, "WeatherStack");
    }
}
