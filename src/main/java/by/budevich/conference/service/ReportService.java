package by.budevich.conference.service;

import by.budevich.conference.dao.BaseReportDAO;
import by.budevich.conference.dao.impl.ReportDAO;
import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class ReportService {
    private BaseReportDAO dao;
    private static ReportService instance = new ReportService();

    private ReportService() {
        dao = new ReportDAO();
    }

    public static ReportService getInstance() {
        if(instance==null){
            instance = new ReportService();
        }
        return instance;
    }

    public ArrayList<Report> showReports() throws DAOException {
        return dao.showReports();
    }

    public Report findReportById(long reportId) throws DAOException {
        return dao.findReportById(reportId);
    }

    public void addBasicReportInfo(String reportName, String reportTheses) throws DAOException {
        Report report = new Report(reportName, reportTheses);
        dao.addBasicReportInfo(report);
    }

    public ArrayList<Report> showReportsByAnyId(String entity, long id) throws DAOException {
        return dao.showReportsByAnyId(entity, id);
    }

    public Report findReportByName(String reportName) throws DAOException {
        return dao.findReportByName(reportName);
    }

    public void assignStatusToReport(long reportId, String reportStatus) throws DAOException {
        dao.assignStatusToReport(reportId, reportStatus);
    }

    public void updateReportInfo(Report report) throws DAOException {
        dao.updateReportInfo(report);
    }

    public void deleteReport(String reportId) throws DAOException {
        dao.deleteReport(Long.parseLong(reportId));
    }

    public void addReportTo(String entity, long id, long reportId) throws DAOException {
        dao.addReportTo(entity, id, reportId);
    }

    public void deleteReportFrom(String entity, long reportId, long id) throws DAOException {
        dao.deleteReportFrom(entity, reportId, id);
    }

    public int checkUserReport(long reportId, long userId) throws DAOException {
        return dao.checkUserReport(reportId, userId);
    }
}