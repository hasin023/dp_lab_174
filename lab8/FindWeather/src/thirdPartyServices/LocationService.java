package thirdPartyServices;

import behaviours.ILocationService;

public class LocationService implements ILocationService {

    @Override
    public String getLocation() throws Exception {
        return "London";
    }
}
