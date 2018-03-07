package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.constant.VenueChangeState;
import edu.nju.ticketbooking.model.VenueChange;

import java.util.List;

public interface VenueChangeDao {

    VenueChange getVenueChange(int venueChangeId);

    VenueChange modifyVenueChange(VenueChange modifiedVenueChange);

    VenueChange addNewVenueChange(VenueChange newVenueChange);

    List<VenueChange> getVenueChangeList(VenueChangeState state, int pageSize, int pageNum);
}
