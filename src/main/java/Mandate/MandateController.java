package Mandate;

import Location.LocationController;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MandateController {

    @RequestMapping(value = "/mandates", method = RequestMethod.POST, headers = "Accept=application/json")
    String sort(@RequestBody String mJson) {

        Gson g = new Gson();
        Mandate mandate = g.fromJson(mJson,Mandate.class);
        LocationController lController = new LocationController();
        return "";
    }


}
