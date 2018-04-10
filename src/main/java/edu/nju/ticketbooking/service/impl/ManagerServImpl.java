package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.constant.VenueApplyState;
import edu.nju.ticketbooking.dao.ManagerDao;
import edu.nju.ticketbooking.dao.UserDao;
import edu.nju.ticketbooking.dao.VenueDao;
import edu.nju.ticketbooking.model.Manager;
import edu.nju.ticketbooking.model.Statistics;
import edu.nju.ticketbooking.model.User;
import edu.nju.ticketbooking.service.ManagerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "managerServ")
public class ManagerServImpl implements ManagerServ, UserDetailsService {

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private VenueDao venueDao;

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

    @Override
    public Statistics getStatistics() {
        List<User> activatedUsers = userDao.getUserList("isActivated", true);
        int activatedUserCount = activatedUsers.size();
        int maleUserCount = (int) activatedUsers.stream().filter(user -> user.getGender().equals("男")).count();
        int femaleUserCount = activatedUserCount - maleUserCount;
        int approvedVenueCount = venueDao.getVenueList(VenueApplyState.APPROVED).size();
        return new Statistics(activatedUserCount, maleUserCount, femaleUserCount, approvedVenueCount);
    }

}
