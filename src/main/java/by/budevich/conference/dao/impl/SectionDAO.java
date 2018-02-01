package by.budevich.conference.dao.impl;

import by.budevich.conference.dao.BaseSectionDAO;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class SectionDAO implements BaseSectionDAO {

    private static SectionDAO instance = new SectionDAO();

    public static SectionDAO getInstance() {
        return instance;
    }

    private static final String SQL_ADD_SECTION_INFO =
            "INSERT INTO section (sectionID, conferenceID, sectionName, maxNumberReports, sectionBeginning, " +
                    "sectionEnd, sectionAddress, sectionContent, sectionStatus) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE_SECTION_INFO = "UPDATE section SET conferenceID = ?, sectionName = ?, maxNumberReports = ?, " +
            "sectionBeginning = ?, sectionEnd = ?, sectionAddress = ?, sectionContent = ?, sectionStatus = ?" +
            " WHERE sectionID = ?";

    private static final String SQL_DELETE_SECTION = "DELETE FROM section WHERE sectionID = ?";

    private static final String SQL_DELETE_SECTIONS_BY_CONFERENCE_ID = "DELETE FROM section WHERE conferenceID = ?";

    private static final String SQL_VIEW_SECTIONS = "SELECT sectionID, conferenceID, sectionName, maxNumberReports, sectionBeginning, " +
            "sectionEnd, sectionAddress, sectionContent, sectionStatus" +
            " FROM section";

    private static final String SQL_FIND_SECTIONS_BY_CONFERENCE = "SELECT sectionID, conferenceID, sectionName, maxNumberReports, sectionBeginning, " +
            "sectionEnd, sectionAddress, sectionContent, sectionStatus" +
            " FROM section " +
            "WHERE conferenceID = ?";

    private static final String SQL_FIND_SECTION_BY_ID = "SELECT sectionID, conferenceID, sectionName, maxNumberReports, sectionBeginning, " +
            "sectionEnd, sectionAddress, sectionContent, sectionStatus" +
            " FROM section " +
            "WHERE sectionID = ?";

    private static final String SQL_FIND_SECTIONS_BY_NAME = "SELECT sectionID, conferenceID, sectionName, maxNumberReports, sectionBeginning, " +
            "sectionEnd, sectionAddress, sectionContent, sectionStatus" +
            " FROM section " +
            "WHERE sectionName = ?";

    private Section initSection(ResultSet resultSet) throws SQLException {
        Section section = new Section();
        section.setSectionId(resultSet.getLong(1));
        section.setConferenceId(resultSet.getLong(2));
        section.setSectionName(resultSet.getString(3));
        section.setMaxNumberReports(resultSet.getInt(4));
        section.setSectionBeginning(resultSet.getTimestamp(5));
        section.setSectionEnd(resultSet.getTimestamp(6));
        section.setSectionAddress(resultSet.getString(7));
        section.setSectionContent(resultSet.getString(8));
        section.setSectionStatus(resultSet.getString(9));
        return section;
    }

    private ArrayList<Section> initSectionTable(ResultSet resultSet) throws SQLException {
        ArrayList<Section> sections = new ArrayList<Section>();
        Section section;
        while (resultSet.next()) {
            section = initSection(resultSet);
            sections.add(section);
        }
        return sections;
    }

    public void addSectionInfo(Section section) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_SECTION_INFO);
        preparedStatement.setLong(1, section.getSectionId());
        preparedStatement.setLong(2, section.getConferenceId());
        preparedStatement.setString(3, section.getSectionName());
        preparedStatement.setInt(4, section.getMaxNumberReports());
        preparedStatement.setTimestamp(5, section.getSectionBeginning());
        preparedStatement.setTimestamp(6, section.getSectionEnd());
        preparedStatement.setString(7, section.getSectionAddress());
        preparedStatement.setString(8, section.getSectionContent());
        preparedStatement.setString(9, section.getSectionStatus());
        preparedStatement.executeUpdate();
    }

    public void updateSectionInfo(Section section) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_SECTION_INFO);
        preparedStatement.setLong(1, section.getConferenceId());
        preparedStatement.setString(2, section.getSectionName());
        preparedStatement.setInt(3, section.getMaxNumberReports());
        preparedStatement.setTimestamp(4, section.getSectionBeginning());
        preparedStatement.setTimestamp(5, section.getSectionEnd());
        preparedStatement.setString(6, section.getSectionAddress());
        preparedStatement.setString(7, section.getSectionContent());
        preparedStatement.setString(8, section.getSectionStatus());
        preparedStatement.setLong(9, section.getSectionId());
        preparedStatement.executeUpdate();
    }

    public void deleteSection(long sectionId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_SECTION);
        preparedStatement.setLong(1, sectionId);
        preparedStatement.executeUpdate();
    }

    public void deleteSectionsByConference(long conferenceId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_SECTIONS_BY_CONFERENCE_ID);
        preparedStatement.setLong(1, conferenceId);
        preparedStatement.executeUpdate();
    }

    public ArrayList<Section> showSections() throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SQL_VIEW_SECTIONS);
        ArrayList<Section> reportList = initSectionTable(result);
        return reportList;
    }

    public ArrayList<Section> showSectionsByConferenceId(long conferenceId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_SECTIONS_BY_CONFERENCE);
        preparedStatement.setLong(1, conferenceId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return initSectionTable(resultSet);
    }

    public Section findSectionById(long sectionId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_SECTION_BY_ID);
        preparedStatement.setLong(1, sectionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return initSection(resultSet);
        } else {
            return null;
        }
    }

    public ArrayList<Section> findSectionsByName(String sectionName) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_SECTIONS_BY_NAME);
        preparedStatement.setString(1, sectionName);
        ResultSet resultSet = preparedStatement.executeQuery();
        return initSectionTable(resultSet);
    }

}
