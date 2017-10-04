package Location;


import Application.ConnectionProvider;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class LocationDAOImpl implements LocationDAO {

    @Override
    public boolean addLocation(Location location) {

        location.recalcCenter();
        Transaction tx = ConnectionProvider.getSession().beginTransaction();
        ConnectionProvider.getSession().persist(location);
        tx.commit();
        return true;
    }

    @Override
    public Location getLocation(String product_id, String store_id)  {

        if(product_id==null||store_id==null){
            return null;
        }

        String queryString = "from Location where product_id='"+product_id+"' AND store_id='"+store_id+"'";
        Query query = ConnectionProvider.getSession().createQuery(queryString);
        try{
            return (Location) query.getSingleResult();
        }catch (NoResultException nre){
            return null;
        }

    }

}
