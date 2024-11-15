import models.WeatherData;
import proxy.WeatherServiceProxy;
import thirdPartyServices.LocationService;

public class App {
    public static void main(String[] args) throws Exception {
        WeatherServiceProxy weatherService = new WeatherServiceProxy();
        LocationService locationService = new LocationService();

        try {

            WeatherData londonData = weatherService.getWeatherData(locationService.getCity());
            londonData.printWeatherDetails();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
