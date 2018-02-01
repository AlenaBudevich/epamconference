package by.budevich.conference.service;

import by.budevich.conference.dao.BaseReportDAO;
import by.budevich.conference.dao.impl.ReportDAO;
import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;

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

    public ArrayList<Report> showReports() throws ServiceException, SQLException {
        try {
            return dao.showReports();
        } catch (DAOException e) {
            throw new ServiceException("Can't show report table ", e);
        }
    }

    public Report findReportById(long reportId) throws ServiceException, SQLException {
        try {
            return dao.findReportById(reportId);
        } catch (DAOException e) {
            throw new ServiceException("Can't find report with such id ", e);
        }
    }

    public void addBasicReportInfo(String reportName, String reportTheses) throws ServiceException,
            SQLException, DAOException {
        try {
            Report report = new Report(reportName, reportTheses);
            dao.addBasicReportInfo(report);
        } catch (DAOException e) {
            throw new ServiceException("Can't add report to a database ", e);
        }
    }

    public ArrayList<Report> showReportsByAnyId(String entity, long id) throws ServiceException, SQLException {
        try {
            return dao.showReportsByAnyId(entity, id);
        } catch (DAOException e) {
            throw new ServiceException("Can't show report table by such id", e);
        }
    }

    public Report findReportByName(String reportName) throws ServiceException, SQLException {
        try {
            return dao.findReportByName(reportName);
        } catch (DAOException e) {
            throw new ServiceException("Can't find report(s) with such name ", e);
        }
    }

    public void assignStatusToReport(long reportId, String reportStatus) throws ServiceException, SQLException {
        try {
            dao.assignStatusToReport(reportId, reportStatus);
        } catch (DAOException e) {
            throw new ServiceException("Can't assign new status for report with id ", e);
        }
    }

    public void updateReportInfo(Report report)
            throws ServiceException, SQLException {
        try {
            dao.updateReportInfo(report);
        } catch (DAOException e) {
            throw new ServiceException("Can't update report in service method ", e);
        }
    }

    public void deleteReport(String reportId) throws ServiceException, SQLException {
        try {
            dao.deleteReport(Long.parseLong(reportId));
        } catch (DAOException e) {
            throw new ServiceException("Can't delete report in service method ", e);
        }
    }

    public void addReportTo(String entity, long id, long reportId) throws SQLException {
        dao.addReportTo(entity, id, reportId);
    }

    public void deleteReportFrom(String entity, String reportId) throws ServiceException, SQLException {
        dao.deleteReportFrom(entity, Long.parseLong(reportId));
    }
}