package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.TicketDao;
import edu.nju.ticketbooking.model.Ticket;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao {

    @Override
    public Ticket addNewTicket(Ticket newTicket) {
        return (Ticket) HibernateUtil.addNew(newTicket, Ticket.class);
    }

    @Override
    public Ticket modifyTicket(Ticket modifiedTicket) {
        return (Ticket) HibernateUtil.saveModified(modifiedTicket);
    }

}
