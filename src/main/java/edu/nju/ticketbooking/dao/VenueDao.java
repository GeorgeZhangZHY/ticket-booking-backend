package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.constant.VenueApplyState;
import edu.nju.ticketbooking.model.Venue;

import java.util.List;

public interface VenueDao {

    Venue getVenue(int venueId);

    Venue modifyVenue(Venue modifiedVenue);

    Venue addNewVenue(Venue newVenue);

    List<Venue> getVenueList(VenueApplyState state);
}
