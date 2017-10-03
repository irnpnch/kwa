package Location;


import Application.ConnectionProvider;
import com.google.gson.Gson;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LocationDAOImpl implements LocationDAO {

    @Override
    public boolean addLocation(Location location) {
        Transaction tx = ConnectionProvider.getSession().beginTransaction();
        ConnectionProvider.getSession().persist(location);
        tx.commit();
        return true;
    }

    @Override
    public boolean setLocation(Location location) {
        return false;
    }

    @Override
    public List getLocation(String ebus_id) {
        Query query = ConnectionProvider.getSession().createQuery("from Location where ebus_id='"+ebus_id+"'");
        return query.list();
    }

    @Override
    public String getAllLocations() {
        Query query = ConnectionProvider.getSession().createQuery("from Location");
        return new Gson().toJson(query.list());
    }
}
