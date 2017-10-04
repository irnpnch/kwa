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
    public String addLocation(@RequestBody String lJson) {

        Gson g = new Gson();
        Location location = g.fromJson(lJson, Location.class);
        location.recalcCenter();
        LocationDAO locationDAO = new LocationDAOImpl();
        locationDAO.addLocation(location);
        return g.toJson(location);

    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String getLocation(String product_id, String store_id) {

        Gson g = new Gson();
        LocationDAO locationDAO = new LocationDAOImpl();
        return g.toJson(locationDAO.getLocation(product_id, store_id));

    }


}
