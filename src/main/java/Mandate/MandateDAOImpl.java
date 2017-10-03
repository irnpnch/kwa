package Mandate;

import Location.LocationDAOImpl;

public class MandateDAOImpl implements MandateDAO{

    @Override
    public Mandate sortMandate(Mandate mandate) {
        //TODO: Implement TSP-Finder

        for(Mandate.Position p : mandate.positions){
            LocationDAOImpl locationDAO = new LocationDAOImpl();
            locationDAO.getLocation(p.ebus_id);
        }
        return mandate;
    }
}
