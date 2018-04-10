package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.SummaryDao;
import edu.nju.ticketbooking.model.Summary;
import edu.nju.ticketbooking.model.Venue;
import edu.nju.ticketbooking.service.SummaryServ;
import edu.nju.ticketbooking.service.VenueServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "SummaryServ")
public class SummaryServImpl implements SummaryServ {

    @Autowired
    private SummaryDao summaryDao;

    @Autowired
    private VenueServ venueServ;

    @Override
    public List<Summary> getAllSummaryList() {
        return summaryDao.getAllSummaryList();
    }

    @Override
    public void handleSummary(int summaryId) {
        Summary summary = summaryDao.getSummary(summaryId);
        summary.setHandled(true);
        // 为相关场馆添加收入
        Venue venue = venueServ.getVenue(summary.getVenueId());
        venue.setProfit(venue.getProfit() + summary.getVenueIncome());
        summaryDao.modifySummary(summary);
        venueServ.modifyVenue(venue);
    }

    @Override
    public Summary addNewUnhandledSummary(Summary newSummary) {
        return summaryDao.addNewUnhandledSummary(newSummary);
    }

}
