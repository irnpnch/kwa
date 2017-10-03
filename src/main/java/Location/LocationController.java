package Location;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import Location.*;

@RestController
public class LocationController {

    @RequestMapping(value = "/locations", method = RequestMethod.POST, headers = "Accept=application/json")
    String addLocation(@RequestBody String locationData) {

        Gson g = new Gson();
        Location location = g.fromJson(locationData, Location.class);
        LocationDAO locationDAO = new LocationDAOImpl();
        locationDAO.addLocation(location);
        return g.toJson(location);

    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    String getLocations() {

        LocationDAO locationDAO = new LocationDAOImpl();
        return locationDAO.getAllLocations();

    }

}
