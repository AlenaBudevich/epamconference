package by.budevich.conference.dao.impl;

/**
 * Created by Asus on 24.01.2018.
 */

import by.budevich.conference.dao.BaseReportDAO;
import by.budevich.conference.entity.*;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Asus on 23.01.2018.
 */
public class ReportDAO implements BaseReportDAO {
    private static ReportDAO instance = new ReportDAO();

    public static ReportDAO getInstance() {
        return instance;
    }

    private static final String SQL_ADD_BASIC_REPORT_INFO =
            "INSERT INTO report (reportName, reportTheses) VALUES (?,?)";

    private static final String SQL_VIEW_REPORTS = "SELECT reportID, reportName," +
            "reportTheses, reportStatus, reportContent" +
            " FROM report";

    private static final String SQL_FIND_REPORT_BY_ID = "SELECT reportID, reportName," +
            "reportTheses, reportStatus, reportContent" +
            " FROM report " +
            "WHERE reportID = ?";

    private static final String SQL_FIND_REPORT_BY_NAME = "SELECT reportID, reportName," +
            "reportTheses, reportStatus, reportContent" +
            " FROM report " +
            "WHERE reportName = ? ";

    private static final String SQL_UPDATE_REPORT_INFO = "UPDATE report SET reportName = ?, " +
            "reportTheses = ?, reportContent = ?" +
            " WHERE reportID = ?";

    private static final String SQL_ASSIGN_STATUS_TO_REPORT = "UPDATE report SET reportStatus = ? WHERE reportID = ?";

    private static final String SQL_DELETE_REPORT = "DELETE FROM report WHERE reportID = ?";

    private static final String SQL_DELETE_REPORT_FROM_USER = "DELETE FROM reportuser WHERE reportID = ?";

    private static final String SQL_DELETE_REPORT_FROM_SECTION = "DELETE FROM sectionreport WHERE reportID = ?";

    private static final String SQL_DELETE_REPORT_FROM_CONFERENCE = "DELETE FROM conferencereport WHERE reportID = ?";

    private static final String SQL_VIEW_REPORTS_BY_USER = "SELECT report.reportID, report.reportName," +
            "report.reportTheses, report.reportStatus, report.reportContent" +
            " FROM report " +
            "INNER JOIN reportuser ON report.reportID = reportuser.reportID" +
            " WHERE reportuser.userID = ?";

    private static final String SQL_VIEW_REPORTS_BY_SECTION = "SELECT report.reportID, report.reportName," +
            "report.reportTheses, report.reportStatus, report.reportContent" +
            " FROM report " +
            "INNER JOIN sectionreport ON report.reportID = sectionreport.reportID" +
            " WHERE sectionreport.sectionID = ?";

    private static final String SQL_VIEW_REPORTS_BY_CONFERENCE = "SELECT report.reportID, report.reportName," +
            "report.reportTheses, report.reportStatus, report.reportContent" +
            " FROM report " +
            "INNER JOIN conferencereport ON report.reportID = conferencereport.reportID" +
            " WHERE conferencereport.conferenceID = ?";

    private static final String SQL_ADD_REPORT_TO_USER =
            "INSERT INTO reportuser (userID, reportID) VALUES (?,?)";

    private static final String SQL_ADD_REPORT_TO_SECTION =
            "INSERT INTO sectionreport (sectionID, reportID) VALUES (?,?)";

    private static final String SQL_ADD_REPORT_TO_CONFERENCE =
            "INSERT INTO conferencereport (conferenceID, reportID) VALUES (?,?)";

    private Report initReport(ResultSet resultSet) throws SQLException {
        Report report = new Report();
        report.setReportId(resultSet.getLong(1));
        report.setReportName(resultSet.getString(2));
        report.setReportTheses(resultSet.getString(3));
        report.setReportStatus(resultSet.getString(4));
        report.setReportContent(resultSet.getString(5));
        return report;
    }

    private ArrayList<Report> initReportTable(ResultSet resultSet) throws SQLException {
        ArrayList<Report> reports = new ArrayList<Report>();
        Report report;
        while (resultSet.next()) {
            report = initReport(resultSet);
            reports.add(report);
        }
        return reports;
    }

    public ArrayList<Report> showReports() throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SQL_VIEW_REPORTS);
        ArrayList<Report> reportList = initReportTable(result);
        return reportList;
    }


    public Report findReportById(long id) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_REPORT_BY_ID);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return initReport(resultSet);
        } else {
            return null;
        }
    }

    public void addBasicReportInfo(Report report) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_BASIC_REPORT_INFO);
        preparedStatement.setString(1, report.getReportName());
        preparedStatement.setString(2, report.getReportTheses());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Report> showReportsByAnyId(String entity, long id) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        if (entity.equalsIgnoreCase(EntityEnum.USER.name())) {
            preparedStatement = connection.prepareStatement(SQL_VIEW_REPORTS_BY_USER);
        } else if (entity.equalsIgnoreCase(EntityEnum.SECTION.name())) {
            preparedStatement = connection.prepareStatement(SQL_VIEW_REPORTS_BY_SECTION);
        } else if (entity.equalsIgnoreCase(EntityEnum.CONFERENCE.name())) {
            preparedStatement = connection.prepareStatement(SQL_VIEW_REPORTS_BY_CONFERENCE);
        } else return null;
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return initReportTable(resultSet);
    }

    public ArrayList<Report> findReportByName(String reportName) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_REPORT_BY_NAME);
        preparedStatement.setString(1, reportName);
        ResultSet resultSet = preparedStatement.executeQuery();
        return initReportTable(resultSet);
    }

    public void assignStatusToReport(long reportId, String reportStatus) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_ASSIGN_STATUS_TO_REPORT);
        preparedStatement.setString(1, reportStatus);
        preparedStatement.setLong(2, reportId);
        preparedStatement.executeUpdate();
    }

    public void updateReportInfo(Report report) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_REPORT_INFO);
        preparedStatement.setString(1, report.getReportName());
        preparedStatement.setString(2, report.getReportTheses());
        preparedStatement.setString(3, report.getReportContent());
        preparedStatement.setLong(4, report.getReportId());
        preparedStatement.executeUpdate();
    }

    public void deleteReport(long reportId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_REPORT);
        preparedStatement.setLong(1, reportId);
        preparedStatement.executeUpdate();
    }

    public void addReportTo(String entity, long id, long reportId) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        if (entity.equalsIgnoreCase(EntityEnum.USER.name())) {
            preparedStatement = connection.prepareStatement(SQL_ADD_REPORT_TO_USER);
        } else if (entity.equalsIgnoreCase(EntityEnum.SECTION.name())) {
            preparedStatement = connection.prepareStatement(SQL_ADD_REPORT_TO_SECTION);
        } else if (entity.equalsIgnoreCase(EntityEnum.CONFERENCE.name())) {
            preparedStatement = connection.prepareStatement(SQL_ADD_REPORT_TO_CONFERENCE);
        } else return;
        preparedStatement.setLong(1, id);
        preparedStatement.setLong(2, reportId);
        preparedStatement.executeUpdate();
    }

    public void deleteReportFrom(String entity, long reportId) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        if (entity.equalsIgnoreCase(EntityEnum.USER.name())) {
            preparedStatement = connection.prepareStatement(SQL_DELETE_REPORT_FROM_USER);
        } else if (entity.equalsIgnoreCase(EntityEnum.SECTION.name())) {
            preparedStatement = connection.prepareStatement(SQL_DELETE_REPORT_FROM_SECTION);
        } else if (entity.equalsIgnoreCase(EntityEnum.CONFERENCE.name())) {
            preparedStatement = connection.prepareStatement(SQL_DELETE_REPORT_FROM_CONFERENCE);
        } else return;
        preparedStatement.setLong(1, reportId);
        preparedStatement.executeUpdate();
    }
}
