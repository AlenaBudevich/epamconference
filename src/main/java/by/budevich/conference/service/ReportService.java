package by.budevich.conference.service;

import by.budevich.conference.dao.BaseReportDAO;
import by.budevich.conference.dao.impl.ReportDAO;
import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class ReportService {
    static final Logger LOGGER = LogManager.getLogger(ReportService.class);

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
        LOGGER.info("The showReports() method is called");
        return dao.showReports();
    }

    public Report findReportById(long reportId) throws DAOException {
        LOGGER.info("The findReportById() method is called with the input data:" + reportId);
        return dao.findReportById(reportId);
    }

    public void addBasicReportInfo(String reportName, String reportTheses) throws DAOException {
        LOGGER.info("The addBasicReportInfo() method is called with the input data:" + reportName + ", "+reportTheses);
        Report report = new Report(reportName, reportTheses);
        dao.addBasicReportInfo(report);
    }

    public ArrayList<Report> showReportsByAnyId(String entity, long id) throws DAOException {
        LOGGER.info("The showReportsByAnyId() method is called with the input data:" + entity + ", "+id);
        return dao.showReportsByAnyId(entity, id);
    }

    public Report findReportByName(String reportName) throws DAOException {
        LOGGER.info("The findReportByName() method is called with the input data:" + reportName);
        return dao.findReportByName(reportName);
    }

    public void assignStatusToReport(long reportId, String reportStatus) throws DAOException {
        LOGGER.info("The assignStatusToReport() method is called with the input data:" + reportId + ", "+reportStatus);
        dao.assignStatusToReport(reportId, reportStatus);
    }

    public void updateReportInfo(Report report) throws DAOException {
        LOGGER.info("The updateReportInfo() method is called with the input data:" + report.toString());
        dao.updateReportInfo(report);
    }

    public void deleteReport(String reportId) throws DAOException {
        LOGGER.info("The deleteReport() method is called with the input data:" + reportId);
        dao.deleteReport(Long.parseLong(reportId));
    }

    public void addReportTo(String entity, long id, long reportId) throws DAOException {
        LOGGER.info("The addReportTo() method is called with the input data:" + entity+", "+id+", "+reportId);
        dao.addReportTo(entity, id, reportId);
    }

    public void deleteReportFrom(String entity, long reportId, long id) throws DAOException {
        LOGGER.info("The deleteReportFrom() method is called with the input data:" + entity+", "+id+", "+reportId);
        dao.deleteReportFrom(entity, reportId, id);
    }

    public int checkUserReport(long reportId, long userId) throws DAOException {
        LOGGER.info("The checkUserReport() method is called with the input data:" + reportId+", "+userId);
        return dao.checkUserReport(reportId, userId);
    }
}