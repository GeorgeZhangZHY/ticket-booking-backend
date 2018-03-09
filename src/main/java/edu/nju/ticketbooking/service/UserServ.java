package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.User;

public interface UserServ {

    /**
     * 获取已激活的用户信息
     */
    User getUser(int id);

//    User login(String email, String password);

//    boolean logout();

    void deleteUser(int id);

    /**
     * 修改用户信息
     *
     * @param modifiedUser 修改后的用户信息
     * @return 修改后的用户信息，若修改失败则为null
     */
    User modifyUser(User modifiedUser);

    /**
     * 申请新用户
     */
    User applyForNewUser(User user);

    void addScore(int userId, double scoreToAdd);

}
