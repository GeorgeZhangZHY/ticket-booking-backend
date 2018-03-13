package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.constant.VenueChangeState;
import edu.nju.ticketbooking.dao.VenueChangeDao;
import edu.nju.ticketbooking.model.Page;
import edu.nju.ticketbooking.model.VenueChange;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VenueChangeDaoImpl implements VenueChangeDao {

    @Override
    public VenueChange getVenueChange(int venueChangeId) {
        return (VenueChange) HibernateUtil.getById(venueChangeId, VenueChange.class);
    }

    @Override
    public VenueChange modifyVenueChange(VenueChange modifiedVenueChange) {
        return (VenueChange) HibernateUtil.saveModified(modifiedVenueChange);
    }

    @Override
    public VenueChange addNewVenueChange(VenueChange newVenueChange) {
        return (VenueChange) HibernateUtil.addNew(newVenueChange, VenueChange.class);
    }

    @Override
    public List<VenueChange> getVenueChangeList(VenueChangeState state, int pageSize, int pageNum) {
        String query = "FROM VenueChange WHERE state = ? ORDER BY submitTime DESC";
        return HibernateUtil.getPageByQuery(query, new Object[]{state}, new Page(pageSize, pageNum));
    }
}
