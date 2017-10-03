package Location;

import java.util.List;

public interface LocationDAO {

    boolean addLocation(Location location);
    boolean setLocation(Location location);
    List getLocation(String ebus_id);
    String getAllLocations();

}
