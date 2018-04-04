package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.VenueDao;
import edu.nju.ticketbooking.model.Venue;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

@Repository
public class VenueDaoImpl implements VenueDao {

    @Override
    public Venue getVenue(int venueId) {
        return (Venue) HibernateUtil.getById(venueId, Venue.class);
    }

    @Override
    public Venue modifyVenue(Venue modifiedVenue) {
        return (Venue) HibernateUtil.saveModified(modifiedVenue);
    }

    @Override
    public Venue addNewVenue(Venue newVenue) {
        return (Venue) HibernateUtil.addNew(newVenue, Venue.class);
    }

}
