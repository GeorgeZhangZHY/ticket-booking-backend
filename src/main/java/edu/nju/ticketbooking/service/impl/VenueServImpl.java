package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.VenueDao;
import edu.nju.ticketbooking.model.Venue;
import edu.nju.ticketbooking.service.VenueServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "venueServ")
public class VenueServImpl implements VenueServ, UserDetailsService {

    @Autowired
    private VenueDao venueDao;

    @Override
    public Venue applyForNewVenue(Venue newVenue) {
        return venueDao.addNewVenue(newVenue);
    }

    @Override
    public void setVenueApplicationApproved(int venueId, boolean isApproved) {
        Venue venue = venueDao.getVenue(venueId);
        venue.setApproved(isApproved);
        venueDao.modifyVenue(venue);
    }

    @Override
    public Venue getVenue(int venueId) {
        return venueDao.getVenue(venueId);
    }

    @Override
    public Venue modifyVenue(Venue modifiedVenue) {
        return venueDao.modifyVenue(modifiedVenue);
    }

    /**
     * 用于登录
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Venue venue = venueDao.getVenue(Integer.parseInt(s));
        return venue != null && venue.getIsApproved() ? venue : null;
    }
}
