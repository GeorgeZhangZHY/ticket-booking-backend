package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.Ticket;
import edu.nju.ticketbooking.service.TicketServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired
    private TicketServ ticketServ;

    /**
     * 用于现场非会员购票
     */
    @PostMapping(value = "/ticket")
    public Ticket addNewTicket(@RequestBody Ticket newTicket) {
        return ticketServ.addNewTicket(newTicket);
    }

    @PutMapping(value = "/ticket")
    public Ticket modifyTicket(@RequestBody Ticket modifiedTicket) {
        return ticketServ.modifyTicket(modifiedTicket);
    }

    @PutMapping(value = "/ticket/check")
    public void checkTicket(@RequestParam(value = "ticketId") int ticketId) {
        ticketServ.checkTicket(ticketId);
    }
}
