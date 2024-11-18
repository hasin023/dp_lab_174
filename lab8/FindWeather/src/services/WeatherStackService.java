package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

import behaviours.IWeatherService;
import models.LocationData;
import models.WeatherData;

public class WeatherStackService implements IWeatherService {
        private final String WEATHERSTACK_API_KEY = "b241366e762063ba924efb466bb650d9";
        private LocationService locationService = new LocationService();
        private final HttpClient httpClient;

        public WeatherStackService() {
                this.httpClient = HttpClient.newHttpClient();
        }

        @Override
        public CompletableFuture<WeatherData> getWeatherData() throws Exception {
                CompletableFuture<LocationData> locationFuture = locationService.getLocationData();
                LocationData locationData = locationFuture.get();

                String REQ_URL = MessageFormat.format(
                                "http://api.weatherstack.com/current?access_key={0}&query={1}&units=m",
                                WEATHERSTACK_API_KEY, locationData.getCity());

                HttpRequest request = HttpRequest.newBuilder()
                                .GET()
                                .uri(URI.create(REQ_URL))
                                .build();

                try {
                        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                        return CompletableFuture.completedFuture(parseWeatherStackResponse(response.body()));
                } catch (Exception e) {
                        CompletableFuture<WeatherData> future = new CompletableFuture<>();
                        future.completeExceptionally(e);
                        return future;
                }
        }

        // {"request":{"type":"City","query":"Tongi,
        // Bangladesh","language":"en","unit":"m"},"location":{"name":"Tongi","country":"Bangladesh","region":"","lat":"23.890","lon":"90.406","timezone_id":"Asia\/Dhaka","localtime":"2024-11-15
        // 20:49","localtime_epoch":1731703740,"utc_offset":"6.0"},"current":{"observation_time":"02:49
        // PM","temperature":24,"weather_code":113,"weather_icons":["https:\/\/cdn.worldweatheronline.com\/images\/wsymbols01_png_64\/wsymbol_0008_clear_sky_night.png"],"weather_descriptions":["Clear
        // "],"wind_speed":12,"wind_degree":330,"wind_dir":"NNW","pressure":1011,"precip":0,"humidity":57,"cloudcover":0,"feelslike":25,"uv_index":0,"visibility":10,"is_day":"no"}}
        public WeatherData parseWeatherStackResponse(String jsonBody) {
                String location = jsonBody.split("\"name\":\"")[1].split("\"")[0];
                double temperature = Double.parseDouble(jsonBody.split("\"temperature\":")[1].split(",")[0]);
                String weatherDescription = jsonBody.split("\"weather_descriptions\":\\[\"")[1].split("\"")[0];

                return new WeatherData(temperature, weatherDescription, location, "WeatherStack");
        }
}
