package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.Ticket;

public interface TicketDao {

    Ticket addNewTicket(Ticket newTicket);

    Ticket modifyTicket(Ticket modifiedTicket);


}
