import models.WeatherData;
import proxy.WeatherServiceProxy;

public class App {
    public static void main(String[] args) throws Exception {
        WeatherServiceProxy weatherService = new WeatherServiceProxy();

        try {
            WeatherData londonData = weatherService.getWeatherData("Gulshan");
            londonData.printWeatherDetails();

            WeatherData tokyoData = weatherService.getWeatherData("Uttara");
            tokyoData.printWeatherDetails();

            WeatherData cachedLondonData = weatherService.getWeatherData("Gulshan");
            cachedLondonData.printWeatherDetails();

            WeatherData cachedTokyoData = weatherService.getWeatherData("Uttara");
            cachedTokyoData.printWeatherDetails();

            weatherService.showOpenWeatherRequestCount();

            weatherService.resetCache();

            WeatherData newLondonData = weatherService.getWeatherData("Gulshan");
            newLondonData.printWeatherDetails();

            WeatherData newTokyoData = weatherService.getWeatherData("Uttara");
            newTokyoData.printWeatherDetails();

            weatherService.resetCache();
            weatherService.resetOpenWatherRequestCount();
            weatherService.showOpenWeatherRequestCount();

            WeatherData moreLondonData = weatherService.getWeatherData("Gulshan");
            moreLondonData.printWeatherDetails();

            WeatherData moreTokyoData = weatherService.getWeatherData("Uttara");
            moreTokyoData.printWeatherDetails();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
