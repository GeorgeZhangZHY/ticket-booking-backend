package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.ManagerDao;
import edu.nju.ticketbooking.model.Manager;
import edu.nju.ticketbooking.service.ManagerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServImpl implements ManagerServ {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public Manager login(String name, String password) {
        // todo
        return null;
    }
}
