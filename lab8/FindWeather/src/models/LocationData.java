package models;

public class LocationData {
    private String country;
    private String city;
    private String latitude;
    private String longitude;

    public LocationData(String country, String city, String latitude, String longitude) {
        this.country = country;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
