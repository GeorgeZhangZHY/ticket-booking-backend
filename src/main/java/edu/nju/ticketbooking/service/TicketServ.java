package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Ticket;

public interface TicketServ {

    /**
     * 先调用此方法再调用addNewOrder
     */
    Ticket addNewTicket(Ticket newTicket);

    Ticket modifyTicket(Ticket modifiedTicket);

    void checkTicket(int ticketId);
}
