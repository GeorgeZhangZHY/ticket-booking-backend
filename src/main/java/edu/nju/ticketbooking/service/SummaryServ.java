package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Summary;

import java.util.List;

public interface SummaryServ {

    List<Summary> getUnhandledSummaryList();

    void handleSummary(int summaryId);

    Summary addNewUnhandledSummary(Summary newSummary);

}
