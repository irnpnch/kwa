package Location;

import java.util.List;

public interface LocationDAO {

    boolean addLocation(Location location);
    Location getLocation(String ebus_id, String store_id);

}
