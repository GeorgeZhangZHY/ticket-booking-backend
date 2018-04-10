package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.UserDao;
import edu.nju.ticketbooking.model.User;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User getUser(int userId) {
        return (User) HibernateUtil.getById(userId, User.class);
    }

    @Override
    public User getUserByEmail(String email) {
        String query = "FROM User WHERE email = ?";
        return (User) HibernateUtil.getSingleByQuery(query, new Object[]{email});
    }

    @Override
    public User modifyUser(User modifiedUser) {
        return (User) HibernateUtil.saveModified(modifiedUser);
    }

    @Override
    public User addNewUser(User newUser) {
        return (User) HibernateUtil.addNew(newUser, User.class);
    }

    @Override
    public List<User> getUserList(String condition, Object value) {
        String query = "FROM User";
        Object[] params = null;
        if (condition != null && value != null) {
            query += " WHERE " + condition + " = ?";
            params = new Object[]{value};
        }
        return HibernateUtil.getListByQuery(query, params);
    }

}
