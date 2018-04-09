package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.constant.VenueApplyState;
import edu.nju.ticketbooking.dao.VenueDao;
import edu.nju.ticketbooking.model.Venue;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Venue> getVenueList(VenueApplyState state) {
        String query = "FROM Venue";
        Object[] params = null;
        if (state != null) {
            query += " WHERE state = ?";
            params = new Object[]{state};
        }
        return HibernateUtil.getListByQuery(query, params);
    }

}
