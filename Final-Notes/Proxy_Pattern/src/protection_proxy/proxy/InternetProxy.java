package protection_proxy.proxy;

import protection_proxy.internet.Internet;
import protection_proxy.internet.RealInternet;

public class InternetProxy implements Internet {
    private Internet realInternet;
    private static final String[] RESTRICTED_SITES = {
            "restricted.com",
            "malicious.org",
            "blocked.net"
    };

    public InternetProxy() {
        this.realInternet = new RealInternet();
    }

    @Override
    public void connectTo(String serverHost) throws Exception {
        // Check access before connecting
        for (String site : RESTRICTED_SITES) {
            if (serverHost.contains(site)) {
                throw new Exception("Access Denied: Connection to " + serverHost + " is blocked");
            }
        }

        // If access is allowed, delegate to the real object
        System.out.println("Proxy: Access check passed");
        realInternet.connectTo(serverHost);
    }
}
