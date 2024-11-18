package abstracts;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import behaviours.IWeatherService;
import models.LocationData;
import models.WeatherData;
import services.LocationService;

public abstract class AbstractWeatherService implements IWeatherService {
    protected final LocationService locationService;
    protected final HttpClient httpClient;
    protected final String apiKey;

    public AbstractWeatherService(String apiKey) {
        this.locationService = new LocationService();
        this.httpClient = HttpClient.newHttpClient();
        this.apiKey = apiKey;
    }

    @Override
    public CompletableFuture<WeatherData> getWeatherData() throws Exception {
        CompletableFuture<LocationData> locationFuture = locationService.getLocationData();
        LocationData locationData = locationFuture.get();

        String requestUrl = buildRequestUrl(locationData);
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(requestUrl))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return CompletableFuture.completedFuture(parseWeatherResponse(response.body()));
        } catch (Exception e) {
            CompletableFuture<WeatherData> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    protected abstract String buildRequestUrl(LocationData locationData);

    protected abstract WeatherData parseWeatherResponse(String jsonBody);
}
