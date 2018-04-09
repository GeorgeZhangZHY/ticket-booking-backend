package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.Summary;
import edu.nju.ticketbooking.service.SummaryServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SummaryController {

    @Autowired
    private SummaryServ summaryServ;

    @GetMapping(value = "/summary")
    public List<Summary> getUnhandledSummaryList() {
        return summaryServ.getUnhandledSummaryList();
    }

    @PutMapping(value = "/summary")
    public void handleSummary(@RequestParam(value = "summaryId") int summaryId) {
        summaryServ.handleSummary(summaryId);
    }

}
