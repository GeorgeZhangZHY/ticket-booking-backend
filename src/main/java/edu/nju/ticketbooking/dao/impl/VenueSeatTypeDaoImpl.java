package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.VenueSeatTypeDao;
import edu.nju.ticketbooking.model.VenueSeatType;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

@Repository
public class VenueSeatTypeDaoImpl implements VenueSeatTypeDao {

    @Override
    public VenueSeatType addNewVenueSeatType(VenueSeatType newVenueSeatType) {
        return (VenueSeatType) HibernateUtil.addNew(newVenueSeatType, VenueSeatType.class);
    }

    @Override
    public VenueSeatType getVenueSeatType(int venueSeatTypeId) {
        return (VenueSeatType) HibernateUtil.getById(venueSeatTypeId, VenueSeatType.class);
    }

    @Override
    public VenueSeatType modifyVenueSeatType(VenueSeatType modifiedVenueSeatType) {
        return (VenueSeatType) HibernateUtil.saveModified(modifiedVenueSeatType);
    }

    @Override
    public void deleteVenueSeatType(int venueSeatTypeId) {
        HibernateUtil.deleteById(venueSeatTypeId, VenueSeatType.class);
    }

}
