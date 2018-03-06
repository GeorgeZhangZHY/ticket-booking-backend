package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.User;

public interface UserDao {

    User getUser(int id);

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
    User addNewUser(User newUser);

}
