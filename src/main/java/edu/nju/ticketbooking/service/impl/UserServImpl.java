package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.UserDao;
import edu.nju.ticketbooking.model.User;
import edu.nju.ticketbooking.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServImpl implements UserServ {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(int id) {
        User user = userDao.getUser(id);
        return user != null && user.getIsActivated() ? user : null;
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User modifyUser(User modifiedUser) {
        return userDao.modifyUser(modifiedUser);
    }

    @Override
    public User applyForNewUser(User user) {
        return userDao.addNewUser(user);
    }
}
