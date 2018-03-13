package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.constant.VenueChangeState;
import edu.nju.ticketbooking.model.VenueChange;

import java.util.List;

public interface VenueChangeServ {

    void setVenueChangeApproved(int venueChangeId, boolean isApproved);

    VenueChange addNewVenueChange(VenueChange newVenueChange);

    List<VenueChange> getVenueChangeList(VenueChangeState state, int pageSize, int pageNum);
}
