package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.ManagerDao;
import edu.nju.ticketbooking.model.Manager;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerDaoImpl implements ManagerDao {

    @Override
    public Manager getManager(int managerId) {
        return (Manager) HibernateUtil.getById(managerId, Manager.class);
    }

}
