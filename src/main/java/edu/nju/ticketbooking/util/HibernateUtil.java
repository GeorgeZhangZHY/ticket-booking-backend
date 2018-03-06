package edu.nju.ticketbooking.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = initSessionFactory();

    private static SessionFactory initSessionFactory() {
        Configuration config = new Configuration().configure();
        return config.buildSessionFactory();
    }

    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public static Object saveModified(Object modifiedObj) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(modifiedObj);
        transaction.commit();
        return modifiedObj;
    }

    public static Object addNew(Object newObj, Class objClass) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(newObj);
        Object savedObj = session.get(objClass, id);
        transaction.commit();
        return savedObj;
    }

    public static Object getById(int id, Class objClass) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Object obj = session.get(objClass, id);
        transaction.commit();
        return obj;
    }

    public static List getListByQuery(String queryStr, Object[] params) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(queryStr);

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }

        List result = query.list();
        transaction.commit();
        return result;
    }

    public static void deleteById(int id, Class objClass) {
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(objClass, id));
        transaction.commit();
    }

}
