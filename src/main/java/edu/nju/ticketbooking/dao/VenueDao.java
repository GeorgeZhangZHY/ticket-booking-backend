package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.Venue;

public interface VenueDao {

    Venue getVenue(int venueId);

    Venue modifyVenue(Venue modifiedVenue);

    Venue addNewVenue(Venue newVenue);
}
