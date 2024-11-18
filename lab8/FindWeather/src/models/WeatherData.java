package models;

public class WeatherData {
    private double temperature;
    private String conditions;
    private String location;
    private String source;
    private long timestamp;

    public WeatherData(double temperature, String conditions, String location, String source) {
        this.temperature = temperature;
        this.conditions = conditions;
        this.location = location;
        this.source = source;
        this.timestamp = System.currentTimeMillis();
    }

    public String getLocation() {
        return location;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void updateSource(String value) {
        this.source = value;
    }

    public void printWeatherDetails() {
        System.out.println("\n");
        System.out.println("Requested data for {{" + location + "}} -->>");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Conditions: " + conditions);
        System.out.println("Source: " + source);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String readableDate = sdf.format(new java.util.Date(timestamp));
        System.out.println("Timestamp: " + readableDate);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\n");
    }

}
