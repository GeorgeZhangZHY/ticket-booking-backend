package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.SummaryDao;
import edu.nju.ticketbooking.model.Summary;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SummaryDaoImpl implements SummaryDao {

    @Override
    public List<Summary> getAllSummaryList() {
        return HibernateUtil.getListByQuery("FROM Summary", null);
    }

    @Override
    public Summary modifySummary(Summary modifiedSummary) {
        return (Summary) HibernateUtil.saveModified(modifiedSummary);
    }

    @Override
    public Summary getSummary(int summaryId) {
        return (Summary) HibernateUtil.getById(summaryId, Summary.class);
    }

    @Override
    public Summary addNewUnhandledSummary(Summary newSummary) {
        return (Summary) HibernateUtil.addNew(newSummary, Summary.class);
    }

}
