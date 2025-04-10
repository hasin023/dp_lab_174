package protection_proxy;

import protection_proxy.internet.Internet;
import protection_proxy.proxy.InternetProxy;

public class InternetApp {
    public static void main(String[] args) throws Exception {
        Internet internet = new InternetProxy();

        try {
            internet.connectTo("google.com");
            internet.connectTo("restricted.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            internet.connectTo("example.com/malicious.org");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
