package by.budevich.conference.dao;

import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by Asus on 23.01.2018.
 */
public interface BaseReportDAO {
    void addBasicReportInfo(Report report) throws DAOException;
    void updateReportInfo(Report report) throws DAOException;
    void assignStatusToReport(long reportId, String reportStatus) throws DAOException;
    void deleteReport(long reportId) throws DAOException;
    ArrayList<Report> showReports() throws DAOException;
    ArrayList<Report> showReportsByAnyId(String entity, long id) throws DAOException;
    Report findReportById(long id) throws DAOException;
    Report findReportByName(String reportName) throws DAOException;
    void addReportTo (String entity, long id, long reportId) throws DAOException;
    void  deleteReportFrom (String entity, long reportId, long id) throws DAOException;
    int checkUserReport (long reportId, long userId) throws DAOException;
}
