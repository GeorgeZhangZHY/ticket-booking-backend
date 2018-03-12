package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.constant.VenueChangeState;
import edu.nju.ticketbooking.dao.VenueChangeDao;
import edu.nju.ticketbooking.model.Venue;
import edu.nju.ticketbooking.model.VenueChange;
import edu.nju.ticketbooking.service.VenueChangeServ;
import edu.nju.ticketbooking.service.VenueServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueChangeServImpl implements VenueChangeServ {

    @Autowired
    private VenueChangeDao venueChangeDao;

    @Autowired
    private VenueServ venueServ;

    @Override
    public VenueChange modifyVenueChange(VenueChange modifiedVenueChange) {
        return venueChangeDao.modifyVenueChange(modifiedVenueChange);
    }

    @Override
    public void setVenueChangeApproved(int venueChangeId, boolean isApproved) {
        VenueChange change = venueChangeDao.getVenueChange(venueChangeId);
        change.setState(isApproved ? VenueChangeState.APPROVED : VenueChangeState.REJECTED);
        venueChangeDao.modifyVenueChange(change);
        if (isApproved) {
            // 根据申请修改场馆信息
            Venue venue = venueServ.getVenue(change.getVenueId());
            venue.setAddress(change.getNewAddress());
            venue.setDescription(change.getNewDescription());
            venue.setName(change.getNewName());
            venueServ.modifyVenue(venue);
        }
    }

    @Override
    public VenueChange addNewVenueChange(VenueChange newVenueChange) {
        return venueChangeDao.addNewVenueChange(newVenueChange);
    }

    @Override
    public List<VenueChange> getVenueChangeList(VenueChangeState state, int pageSize, int pageNum) {
        return venueChangeDao.getVenueChangeList(state, pageSize, pageNum);
    }
}
