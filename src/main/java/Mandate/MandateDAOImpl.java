package Mandate;

import Location.LocationDAOImpl;

public class MandateDAOImpl implements MandateDAO{

    @Override
    public Mandate sortMandate(Mandate mandate) {
        //TODO: Implement TSP-Finder

        for(Mandate.Position p : mandate.positions){
            LocationDAOImpl locationDAO = new LocationDAOImpl();
            locationDAO.getLocation(p.product_id, mandate.store_id);
        }
        return mandate;
    }
}
