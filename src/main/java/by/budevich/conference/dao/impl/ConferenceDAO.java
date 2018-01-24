package by.budevich.conference.dao.impl;

import by.budevich.conference.dao.BaseConferenceDAO;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class ConferenceDAO implements BaseConferenceDAO {
    private static ConferenceDAO instance = new ConferenceDAO();

    public static ConferenceDAO getInstance(){
        return instance;
    }

    private static final String SQL_ADD_CONFERENCE =
            "INSERT INTO conference (conferenceID, conferenceName, conferenceDescription, " +
                    "muxNumberParticipiants, conferenceBeginning, conferenceEnd, conferenceCountry, " +
                    "conferenceCity, conferenceAddress, conferenceContent, conferenceStatus) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE_CONFERENCE_INFO = "UPDATE conference SET conferenceName = ?, conferenceDescription = ?, " +
            "muxNumberParticipiants = ?, conferenceBeginning = ?, conferenceEnd = ?, conferenceCountry = ?, " +
            "conferenceCity = ?, conferenceAddress = ?, conferenceContent = ? " +
            "WHERE conferenceID = ?";

    private static final String SQL_ASSIGN_CONFERENCE_STATUS = "UPDATE conference SET conferenceStatus = ? WHERE conferenceID = ?";

    private static final String SQL_DELETE_CONFERENCE = " DELETE FROM conference WHERE conferenceID = ?";

    private static final String SQL_VIEW_CONFERENCE_TABLE = "SELECT conferenceID, conferenceName, conferenceDescription, " +
            "muxNumberParticipiants, conferenceBeginning, conferenceEnd, conferenceCountry, " +
            "conferenceCity, conferenceAddress, conferenceContent, conferenceStatus " +
            "FROM conference ";

    private static final String SQL_FIND_CONFERENCE_BY_ID = "SELECT conferenceID, conferenceName, conferenceDescription, " +
            "muxNumberParticipiants, conferenceBeginning, conferenceEnd, conferenceCountry, " +
            "conferenceCity, conferenceAddress, conferenceContent, conferenceStatus " +
            " FROM conference" +
            " WHERE conferenceID = ?";

    private static final String SQL_FIND_CONFERENCE_BY_NAME = "SELECT conferenceID, conferenceName, conferenceDescription, " +
            "muxNumberParticipiants, conferenceBeginning, conferenceEnd, conferenceCountry, " +
            "conferenceCity, conferenceAddress, conferenceContent, conferenceStatus " +
            " FROM conference" +
            " WHERE conferenceName = ?";

    public void addConference(Conference conference) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_CONFERENCE);
        preparedStatement.setLong(1, conference.getConferenceId());
        preparedStatement.setString(2, conference.getConferenceName());
        preparedStatement.setString(3, conference.getConferenceDescription());
        preparedStatement.setInt(4, conference.getMaxNumberParticipiants());
        preparedStatement.setDate(5, (Date) conference.getConferenceBeginning());
        preparedStatement.setDate(6, (Date) conference.getConferenceEnd());
        preparedStatement.setString(7, conference.getConferenceCountry());
        preparedStatement.setString(8, conference.getConferenceCity());
        preparedStatement.setString(9, conference.getConferenceAddress());
        preparedStatement.setString(10, conference.getConferenceContent());
        preparedStatement.setString(11, conference.getConferenceStatus());
        preparedStatement.executeUpdate();

    }

    public void updateConferenceInfo(Conference conference) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_CONFERENCE_INFO);
        preparedStatement.setString(1, conference.getConferenceName());
        preparedStatement.setString(2, conference.getConferenceDescription());
        preparedStatement.setInt(3, conference.getMaxNumberParticipiants());
        preparedStatement.setDate(4, (Date) conference.getConferenceBeginning());
        preparedStatement.setDate(5, (Date) conference.getConferenceEnd());
        preparedStatement.setString(6, conference.getConferenceCountry());
        preparedStatement.setString(7, conference.getConferenceCity());
        preparedStatement.setString(8, conference.getConferenceAddress());
        preparedStatement.setString(9, conference.getConferenceContent());
        preparedStatement.setLong(10, conference.getConferenceId());
        preparedStatement.executeUpdate();
    }

    public void assignStatusToConference(long conferenceId, String conferenceStatus) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_ASSIGN_CONFERENCE_STATUS);
        preparedStatement.setString(1,conferenceStatus);
        preparedStatement.setLong(2,conferenceId);
        preparedStatement.executeUpdate();
    }

    public void deleteConference(long conferenceId) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_CONFERENCE);
        preparedStatement.setLong(1, conferenceId);
        preparedStatement.executeUpdate();
    }

    public ArrayList<Conference> showConferences() throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SQL_VIEW_CONFERENCE_TABLE);
        ArrayList<Conference> conferenceList = initConferenceTable(result);
        return conferenceList;
    }

    public Conference findConferenceById(long conferenceId) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CONFERENCE_BY_ID);
        preparedStatement.setLong(1,conferenceId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return initConference(resultSet);
        }
        else {
            return null;
        }
    }

    public Conference findConferenceByName(String conferenceName) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CONFERENCE_BY_NAME);
        preparedStatement.setString(1,conferenceName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return initConference(resultSet);
        }
        else {
            return null;
        }
    }

    private Conference initConference(ResultSet resultSet) throws SQLException {
        Conference conference = new Conference();
        conference.setConferenceId(resultSet.getLong(1));
        conference.setConferenceName(resultSet.getString(2));
        conference.setConferenceDescription(resultSet.getString(3));
        conference.setMaxNumberParticipiants(resultSet.getInt(4));
        conference.setConferenceBeginning(resultSet.getDate(5));
        conference.setConferenceEnd(resultSet.getDate(6));
        conference.setConferenceCountry(resultSet.getString(7));
        conference.setConferenceCity(resultSet.getString(8));
        conference.setConferenceAddress(resultSet.getString(9));
        conference.setConferenceContent(resultSet.getString(10));
        conference.setConferenceStatus(resultSet.getString(11));
        return conference;

    }

    private ArrayList<Conference> initConferenceTable(ResultSet resultSet) throws SQLException {
        ArrayList<Conference> conferences = new ArrayList<Conference>();
        Conference conference;
        while (resultSet.next()) {
            conference = initConference(resultSet);
            conferences.add(conference);
        }
        return conferences;
    }
}
