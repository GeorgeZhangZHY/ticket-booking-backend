package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Summary;

import java.util.List;

public interface SummaryServ {

    List<Summary> getAllSummaryList();

    void handleSummary(int summaryId);

    Summary addNewUnhandledSummary(Summary newSummary);

}
