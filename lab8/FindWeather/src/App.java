import models.WeatherData;
import proxy.WeatherServiceProxy;

public class App {
    public static void main(String[] args) throws Exception {
        WeatherServiceProxy weatherService = new WeatherServiceProxy();

        try {
            WeatherData data = weatherService.getWeatherData();
            data.printWeatherDetails();

            WeatherData data2 = weatherService.getWeatherData();
            data2.printWeatherDetails();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
