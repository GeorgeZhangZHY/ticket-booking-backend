package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.Summary;

import java.util.List;

public interface SummaryDao {

    List<Summary> getAllSummaryList();

    Summary modifySummary(Summary modifiedSummary);

    Summary getSummary(int summaryId);

    Summary addNewUnhandledSummary(Summary newSummary);

}
