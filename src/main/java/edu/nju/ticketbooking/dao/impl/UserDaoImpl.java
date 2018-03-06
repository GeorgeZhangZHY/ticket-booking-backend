package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.UserDao;
import edu.nju.ticketbooking.model.User;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User getUser(int id) {
        return (User) HibernateUtil.getById(id, User.class);
    }

    @Override
    public void deleteUser(int id) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        user.setDeleted(true);
        session.update(user);
        transaction.commit();
    }

    @Override
    public User modifyUser(User modifiedUser) {
        return (User) HibernateUtil.saveModified(modifiedUser);
    }

    @Override
    public User addNewUser(User newUser) {
        return (User) HibernateUtil.addNew(newUser, User.class);
    }

}
