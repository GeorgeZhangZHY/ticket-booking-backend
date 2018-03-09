package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Ticket;

public interface TicketServ {

    Ticket addNewTicket(Ticket newTicket);

    Ticket modifyTicket(Ticket modifiedTicket);

    void checkTicket(int ticketId);
}
