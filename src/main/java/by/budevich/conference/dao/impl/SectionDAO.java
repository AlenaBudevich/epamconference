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

    private static final String SQL_ADD_SECTION_INFO =
            "INSERT INTO section (sectionID, conferenceID, sectionName, maxNumberReports, sectionBeginning, " +
                    "sectionEnd, sectionAddress, sectionContent, sectionStatus) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE_SECTION_INFO = "UPDATE section SET conferenceID = ?, sectionName = ?, maxNumberReports = ?, " +
            "sectionBeginning = ?, sectionEnd = ?, sectionAddress = ?, sectionContent = ?, sectionStatus = ?" +
            " WHERE sectionID = ?";

    private static final String SQL_DELETE_SECTION = "DELETE FROM section WHERE sectionID = ?";

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
        while (resultSet.next()) {
            section.setSectionId(resultSet.getLong(1));
            section.setConferenceId(resultSet.getLong(2));
            section.setSectionName(resultSet.getString(3));
            section.setMaxNumberReports(resultSet.getInt(4));
            section.setSectionBeginning(resultSet.getTimestamp(5));
            section.setSectionEnd(resultSet.getTimestamp(6));
            section.setSectionAddress(resultSet.getString(7));
            section.setSectionContent(resultSet.getString(8));
            section.setSectionStatus(resultSet.getString(9));
        }
        return section;
    }

    private ArrayList<Section> initSectionTable(ResultSet resultSet) throws SQLException {
        ArrayList<Section> sections = new ArrayList<Section>();
        while (resultSet.next()) {
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
            sections.add(section);
        }
        return sections;
    }

    public void addSectionInfo(Section section) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
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
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while adding section to a database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
    }

    public void updateSectionInfo(Section section) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
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
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating section info in a database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
    }

    public void deleteSection(long sectionId) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_SECTION);
            preparedStatement.setLong(1, sectionId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while deleting section info from a database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
    }

    public ArrayList<Section> showSections() throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        ArrayList<Section> sectionList = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SQL_VIEW_SECTIONS);
            sectionList = initSectionTable(result);
        } catch (SQLException e) {
            throw new DAOException("Can't initialize section list", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return sectionList;
    }

    public ArrayList<Section> showSectionsByConferenceId(long conferenceId) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        ArrayList<Section> sections = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_SECTIONS_BY_CONFERENCE);
            preparedStatement.setLong(1, conferenceId);
            ResultSet resultSet = preparedStatement.executeQuery();
            sections = initSectionTable(resultSet);
        } catch (SQLException e) {
            throw new DAOException("Can't initialize section list", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return sections;
    }

    public Section findSectionById(long sectionId) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Section section = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_SECTION_BY_ID);
            preparedStatement.setLong(1, sectionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            section = initSection(resultSet);
        } catch (SQLException e) {
            throw new DAOException("Cant' find section with such id ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return section;
    }

    public Section findSectionByName(String sectionName) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Section section = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_SECTIONS_BY_NAME);
            preparedStatement.setString(1, sectionName);
            ResultSet resultSet = preparedStatement.executeQuery();
            section = initSection(resultSet);
        } catch (SQLException e) {
            throw new DAOException("Cant' find section with such name ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return section;
    }
}
