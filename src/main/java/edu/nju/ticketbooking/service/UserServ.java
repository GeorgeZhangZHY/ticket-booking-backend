package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.User;

public interface UserServ {

    /**
     * 获取已激活的用户信息
     */
    User getUser(int userId);

    User login(String email, String password);

//    boolean logout();

    void deleteUser(int userId);

    void activateUser(int userId);

    /**
     * 修改用户信息
     * 包括用户名和性别
     * @param modifiedUser 修改后的用户信息
     * @return 修改后的用户信息，若修改失败则为null
     */
    User modifyUser(User modifiedUser);

    /**
     * 申请新用户
     */
    User applyForNewUser(User newUser);

    /**
     * @param scoreDelta  变更的积分数，若为负数表示减分
     * @param accumulated 是否影响累计积分，若影响，则为true
     */
    boolean modifyScore(int userId, double scoreDelta, boolean accumulated);

    /**
     * @param balanceDelta 变更的金额，若为负数表示减少
     */
    boolean modifyBalance(int userId, double balanceDelta);

    double getUserLevelDiscount(int userId);

}
