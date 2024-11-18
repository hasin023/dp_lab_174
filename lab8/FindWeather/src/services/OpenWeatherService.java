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

public class OpenWeatherService implements IWeatherService {
        private final String OPEN_WEATHER_MAP_API_KEY = "e3c9bf35e426c1789775f45994cc305c";
        private LocationService locationService = new LocationService();
        private final HttpClient httpClient;

        public OpenWeatherService() {
                this.httpClient = HttpClient.newHttpClient();
        }

        @Override
        public CompletableFuture<WeatherData> getWeatherData() throws Exception {
                CompletableFuture<LocationData> locationFuture = locationService.getLocationData();
                LocationData locationData = locationFuture.get();

                String REQ_URL = MessageFormat.format(
                                "https://api.openweathermap.org/data/2.5/weather?lat={0}&lon={1}&units=metric&appid={2}",
                                locationData.getLatitude(), locationData.getLongitude(),
                                OPEN_WEATHER_MAP_API_KEY);

                HttpRequest request = HttpRequest.newBuilder()
                                .GET()
                                .uri(URI.create(REQ_URL))
                                .build();

                try {
                        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                        return CompletableFuture.completedFuture(parseOpenWeatherResponse(response.body()));
                } catch (Exception e) {
                        CompletableFuture<WeatherData> future = new CompletableFuture<>();
                        future.completeExceptionally(e);
                        return future;
                }
        }

        // {"coord":{"lon":90.4023,"lat":23.8915},"weather":[{"id":721,"main":"Haze","description":"haze","icon":"50n"}],"base":"stations","main":{"temp":25,"feels_like":25.36,"temp_min":25,"temp_max":25,"pressure":1012,"humidity":69,"sea_level":1012,"grnd_level":1011},"visibility":3200,"wind":{"speed":1.54,"deg":260},"clouds":{"all":40},"dt":1731685022,"sys":{"type":1,"id":9145,"country":"BD","sunrise":1731629603,"sunset":1731669170},"timezone":21600,"id":1185098,"name":"Tongi","cod":200}
        public WeatherData parseOpenWeatherResponse(String jsonBody) {
                String location = jsonBody.split("\"name\":")[1].split(",")[0].replace("\"", "");
                double temperature = Double.parseDouble(jsonBody.split("\"temp\":")[1].split(",")[0]);
                String weatherDescription = jsonBody.split("\"description\":")[1].split(",")[0].replace("\"", "");

                return new WeatherData(temperature, weatherDescription, location, "OpenWeatherMap");
        }
}
