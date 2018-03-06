package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.OrderDao;
import edu.nju.ticketbooking.model.Order;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Order> getUserOrderList(int userId) {
        return HibernateUtil.getListByQuery("FROM Order o WHERE o.userId = ?", new Object[]{userId});
    }

    @Override
    public Order addNewOrder(Order newOrder) {
        return (Order) HibernateUtil.addNew(newOrder, Order.class);
    }

    @Override
    public Order modifyOrder(Order modifiedOrder) {
        return (Order) HibernateUtil.saveModified(modifiedOrder);
    }

    @Override
    public Order getOrder(int orderId) {
        return (Order) HibernateUtil.getById(orderId, Order.class);
    }
}
