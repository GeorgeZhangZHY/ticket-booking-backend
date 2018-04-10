package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.VenueSeatType;

public interface VenueSeatTypeDao {

    VenueSeatType addNewVenueSeatType(VenueSeatType newVenueSeatType);

    VenueSeatType getVenueSeatType(int venueSeatTypeId);

    VenueSeatType modifyVenueSeatType(VenueSeatType modifiedVenueSeatType);

    void deleteVenueSeatType(int venueSeatTypeId);

}
