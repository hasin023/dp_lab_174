import utils.Helper;
import models.WeatherData;
import proxy.WeatherServiceProxy;

public class App {
    public static void main(String[] args) throws Exception {
        Helper helper = new Helper();
        WeatherServiceProxy weatherService = new WeatherServiceProxy();
        WeatherData data;

        helper.clearScreen();
        helper.printHeader();
        while (true) {
            helper.printMenu();
            int option = helper.getOption();

            switch (option) {
                case 1:
                    helper.printWeatherMenu();
                    int weatherOption = helper.getOption();

                    switch (weatherOption) {
                        case 1:
                            data = weatherService.getWeatherData();
                            helper.displayData(data);
                            break;
                        case 2:
                            data = weatherService.getWeatherData();
                            helper.displayData(data);
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    break;
                case 2:
                    weatherService.resetCache();
                    helper.printSuccess("Cache reset successfully");
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
