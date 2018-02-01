package by.budevich.conference.dao;

import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 23.01.2018.
 */
public interface BaseReportDAO {
    void addBasicReportInfo(Report report) throws DAOException, SQLException;
    void updateReportInfo(Report report) throws DAOException, SQLException;
    void assignStatusToReport(long reportId, String reportStatus) throws DAOException, SQLException;
    void deleteReport(long reportId) throws DAOException, SQLException;
    ArrayList<Report> showReports() throws DAOException, SQLException;
    ArrayList<Report> showReportsByAnyId(String entity, long id) throws DAOException, SQLException;
    Report findReportById(long id) throws DAOException, SQLException;
    Report findReportByName(String reportName) throws DAOException, SQLException;
    void addReportTo (String entity, long id, long reportId) throws SQLException;
    void  deleteReportFrom (String entity, long reportId, long id) throws SQLException;
    int checkUserReport (long reportId, long userId) throws DAOException, SQLException;
}
