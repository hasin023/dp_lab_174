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

        String jsonBody = response.body();
        System.out.println(jsonBody);

        // {"request":{"type":"City","query":"Tongi,
        // Bangladesh","language":"en","unit":"m"},"location":{"name":"Tongi","country":"Bangladesh","region":"","lat":"23.890","lon":"90.406","timezone_id":"Asia\/Dhaka","localtime":"2024-11-15
        // 20:49","localtime_epoch":1731703740,"utc_offset":"6.0"},"current":{"observation_time":"02:49
        // PM","temperature":24,"weather_code":113,"weather_icons":["https:\/\/cdn.worldweatheronline.com\/images\/wsymbols01_png_64\/wsymbol_0008_clear_sky_night.png"],"weather_descriptions":["Clear
        // "],"wind_speed":12,"wind_degree":330,"wind_dir":"NNW","pressure":1011,"precip":0,"humidity":57,"cloudcover":0,"feelslike":25,"uv_index":0,"visibility":10,"is_day":"no"}}

        String location = jsonBody.split("location")[1].split("name")[1].split(":")[1].replace("\"", "").trim();
        double temperature = Double.parseDouble(
                jsonBody.split("current")[1].split("temperature")[1].split(":")[1].replace(",", "").trim());
        String weather = jsonBody.split("current")[1].split("weather_descriptions")[1].split(":")[1].replace("\"", "")
                .replace("]", "").trim();

        return new WeatherData(temperature, weather, location, "WeatherStack");
    }
}
