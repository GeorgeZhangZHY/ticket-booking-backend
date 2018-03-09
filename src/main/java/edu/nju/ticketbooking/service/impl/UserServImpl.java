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

    /**
     * 二阶等差
     * 100分2级 300分3级 600分4级 1000分5级，以此类推，最高11级（即5500分）
     */
    private int calcUserLevel(double accumulatedScore) {
        if (accumulatedScore >= 5500) {
            return 11;
        }
        return 1 + (int) (Math.sqrt(8 * (accumulatedScore / 100) + 1) - 1) / 2;
    }

    @Override
    public User getUser(int userId) {
        User user = userDao.getUser(userId);
        return user != null && user.getIsActivated() ? user : null;
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public User modifyUser(User modifiedUser) {
        return userDao.modifyUser(modifiedUser);
    }

    @Override
    public User applyForNewUser(User user) {
        return userDao.addNewUser(user);
    }

    @Override
    public void addScore(int userId, double scoreToAdd) {
        User user = userDao.getUser(userId);
        user.setScore(user.getScore() + scoreToAdd);
        user.setAccumulatedScore(user.getAccumulatedScore() + scoreToAdd);
        user.setLevel(calcUserLevel(user.getAccumulatedScore()));
        modifyUser(user);
    }
}
