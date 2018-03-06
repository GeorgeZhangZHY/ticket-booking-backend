package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Venue;

public interface VenueServ {

    Venue applyForNewVenue(Venue newVenue);

    void setVenueApplicationApproved(int venueId, boolean isApproved);

    // login/logout

    Venue modifyVenue(Venue modifiedVenue);
}
