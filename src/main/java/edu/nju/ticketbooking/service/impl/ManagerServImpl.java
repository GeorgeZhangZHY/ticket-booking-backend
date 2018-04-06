package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.ManagerDao;
import edu.nju.ticketbooking.model.Manager;
import edu.nju.ticketbooking.service.ManagerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "managerServ")
public class ManagerServImpl implements ManagerServ, UserDetailsService {

    @Autowired
    private ManagerDao managerDao;

    /**
     * 用于登录
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return managerDao.getManager(Integer.parseInt(s));
    }

    @Override
    public Manager getManager(int managerId) {
        return managerDao.getManager(managerId);
    }
}
