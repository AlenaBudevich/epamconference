package by.budevich.conference.service;

import by.budevich.conference.dao.BaseReportDAO;
import by.budevich.conference.dao.impl.ReportDAO;
import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class ReportService {
    private BaseReportDAO dao;
    private static ReportService instance = new ReportService();

    private ReportService() {
        dao = ReportDAO.getInstance();
    }

    public static ReportService getInstance() {
        return instance;
    }

    public ArrayList<Report> showReports() throws SQLException, DAOException {
        return dao.showReports();
    }

    public Report findReportById(long reportId) throws SQLException, DAOException {
        return dao.findReportById(reportId);
    }

    public void addBasicReportInfo(String reportName, String reportTheses) throws SQLException, DAOException {
        Report report = new Report(reportName, reportTheses);
        dao.addBasicReportInfo(report);
    }

    public ArrayList<Report> showReportsByAnyId(String entity, long id) throws SQLException, DAOException {
        return dao.showReportsByAnyId(entity, id);
    }

    public Report findReportByName(String reportName) throws SQLException, DAOException {
        return dao.findReportByName(reportName);
    }

    public void assignStatusToReport(long reportId, String reportStatus) throws SQLException, DAOException {
        dao.assignStatusToReport(reportId, reportStatus);
    }

    public void updateReportInfo(Report report) throws SQLException, DAOException {
        dao.updateReportInfo(report);
    }

    public void deleteReport(String reportId) throws SQLException, DAOException {
        dao.deleteReport(Long.parseLong(reportId));
    }

    public void addReportTo(String entity, long id, long reportId) throws SQLException, DAOException {
        dao.addReportTo(entity, id, reportId);
    }

    public void deleteReportFrom(String entity, long reportId, long id) throws SQLException, DAOException {
        dao.deleteReportFrom(entity, reportId, id);
    }

    public int checkUserReport(long reportId, long userId) throws SQLException, DAOException {
        return dao.checkUserReport(reportId, userId);
    }
}