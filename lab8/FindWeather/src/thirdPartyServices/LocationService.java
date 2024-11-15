package thirdPartyServices;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import behaviours.ILocationService;

public class LocationService implements ILocationService {

    private String getIP() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.ipify.org/"))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    private String getLocation() throws Exception {
        String GeoLocationAPI = "http://ip-api.com/json/" + getIP();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(GeoLocationAPI))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        String jsonBody = response.body();

        // {"status":"success","country":"Bangladesh","countryCode":"BD","region":"C","regionName":"Dhaka
        // Division","city":"Dhaka","zip":"1000","lat":23.7272,"lon":90.4093,"timezone":"Asia/Dhaka","isp":"Axiata
        // (Bangladesh) Limited","org":"Robi Axiata Limited","as":"AS24432 TM
        // International Bangladesh Ltd.Internet service
        // Provider,Gulshan-1,Dhaka-1212","query":"202.134.10.135"}

        String city = jsonBody.split(",")[5].split(":")[1].replace("\"", "");
        String country = jsonBody.split(",")[1].split(":")[1].replace("\"", "");
        String lat = jsonBody.split(",")[7].split(":")[1].replace("\"", "");
        String lon = jsonBody.split(",")[8].split(":")[1].replace("\"", "");

        return city + "," + country + "," + lat + "," + lon;
    }

    @Override
    public String getCity() throws Exception {
        try {
            return getLocation().split(",")[0];
        } catch (Exception e) {
            return "Unknown";
        }
    }

    @Override
    public String getCountry() throws Exception {
        try {
            return getLocation().split(",")[1];
        } catch (Exception e) {
            return "Unknown";
        }
    }

    @Override
    public String getLat() throws Exception {
        try {
            return getLocation().split(",")[2];
        } catch (Exception e) {
            return "Unknown";
        }
    }

    @Override
    public String getLon() throws Exception {
        try {
            return getLocation().split(",")[3];
        } catch (Exception e) {
            return "Unknown";
        }
    }

}
