package by.budevich.conference.dao.impl;

import by.budevich.conference.dao.BaseConferenceDAO;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class ConferenceDAO implements BaseConferenceDAO {

    private static final String SQL_ADD_CONFERENCE =
            "INSERT INTO сonference (conferenceID, conferenceName, conferenceDescription, " +
                    "maxNumberParticipants, conferenceBeginning, conferenceEnd, conferenceCountry, " +
                    "conferenceCity, conferenceAddress, conferenceContent, conferenceStatus) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE_CONFERENCE_INFO = "UPDATE сonference SET conferenceName = ?, conferenceDescription = ?, " +
            "maxNumberParticipants = ?, conferenceBeginning = ?, conferenceEnd = ?, conferenceCountry = ?, " +
            "conferenceCity = ?, conferenceAddress = ?, conferenceContent = ?, conferenceStatus = ?" +
            "WHERE conferenceID = ?";

    private static final String SQL_DELETE_CONFERENCE = " DELETE FROM сonference WHERE conferenceID = ?";

    private static final String SQL_VIEW_CONFERENCE_TABLE = "SELECT conferenceID, conferenceName, conferenceDescription, " +
            "maxNumberParticipants, conferenceBeginning, conferenceEnd, conferenceCountry, " +
            "conferenceCity, conferenceAddress, conferenceContent, conferenceStatus " +
            "FROM сonference ";

    private static final String SQL_FIND_CONFERENCE_BY_ID = "SELECT conferenceID, conferenceName, conferenceDescription, " +
            "maxNumberParticipants, conferenceBeginning, conferenceEnd, conferenceCountry, " +
            "conferenceCity, conferenceAddress, conferenceContent, conferenceStatus " +
            " FROM сonference" +
            " WHERE conferenceID = ?";

    private static final String SQL_FIND_CONFERENCE_BY_NAME = "SELECT conferenceID, conferenceName, conferenceDescription, " +
            "maxNumberParticipants, conferenceBeginning, conferenceEnd, conferenceCountry, " +
            "conferenceCity, conferenceAddress, conferenceContent, conferenceStatus " +
            " FROM сonference" +
            " WHERE conferenceName = ?";

    public void addConference(Conference conference) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_CONFERENCE);
            preparedStatement.setLong(1, conference.getConferenceId());
            preparedStatement.setString(2, conference.getConferenceName());
            preparedStatement.setString(3, conference.getConferenceDescription());
            preparedStatement.setInt(4, conference.getMaxNumberParticipants());
            preparedStatement.setTimestamp(5, conference.getConferenceBeginning());
            preparedStatement.setTimestamp(6, conference.getConferenceEnd());
            preparedStatement.setString(7, conference.getConferenceCountry());
            preparedStatement.setString(8, conference.getConferenceCity());
            preparedStatement.setString(9, conference.getConferenceAddress());
            preparedStatement.setString(10, conference.getConferenceContent());
            preparedStatement.setString(11, conference.getConferenceStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while adding conference to a database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }

    }

    public void updateConferenceInfo(Conference conference) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_CONFERENCE_INFO);
            preparedStatement.setString(1, conference.getConferenceName());
            preparedStatement.setString(2, conference.getConferenceDescription());
            preparedStatement.setInt(3, conference.getMaxNumberParticipants());
            preparedStatement.setTimestamp(4, conference.getConferenceBeginning());
            preparedStatement.setTimestamp(5, conference.getConferenceEnd());
            preparedStatement.setString(6, conference.getConferenceCountry());
            preparedStatement.setString(7, conference.getConferenceCity());
            preparedStatement.setString(8, conference.getConferenceAddress());
            preparedStatement.setString(9, conference.getConferenceContent());
            preparedStatement.setString(10, conference.getConferenceStatus());
            preparedStatement.setLong(11, conference.getConferenceId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating user in a database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
    }

    public void deleteConference(long conferenceId) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_CONFERENCE);
            preparedStatement.setLong(1, conferenceId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating user from a database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
    }

    public ArrayList<Conference> showConferences() throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        ArrayList<Conference> conferenceList = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SQL_VIEW_CONFERENCE_TABLE);
            conferenceList = initConferenceTable(result);
        } catch (SQLException e) {
            throw new DAOException("Can't initialize conference list", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return conferenceList;
    }

    public Conference findConferenceById(long conferenceId) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Conference conference = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CONFERENCE_BY_ID);
            preparedStatement.setLong(1, conferenceId);
            ResultSet resultSet = preparedStatement.executeQuery();
            conference = initConference(resultSet);
        } catch (SQLException e) {
            throw new DAOException("Cant' find conference with such id ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return conference;
    }

    public Conference findConferenceByName(String conferenceName) throws DAOException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Conference conference = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CONFERENCE_BY_NAME);
            preparedStatement.setString(1, conferenceName);
            ResultSet resultSet = preparedStatement.executeQuery();
            conference = initConference(resultSet);
        } catch (SQLException e) {
            throw new DAOException("Cant' find conference with such name ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return conference;
    }

    private Conference initConference(ResultSet resultSet) throws SQLException {
        Conference conference = new Conference();
        if (resultSet.next()) {
            conference.setConferenceId(resultSet.getLong(1));
            conference.setConferenceName(resultSet.getString(2));
            conference.setConferenceDescription(resultSet.getString(3));
            conference.setMaxNumberParticipants(resultSet.getInt(4));
            conference.setConferenceBeginning(resultSet.getTimestamp(5));
            conference.setConferenceEnd(resultSet.getTimestamp(6));
            conference.setConferenceCountry(resultSet.getString(7));
            conference.setConferenceCity(resultSet.getString(8));
            conference.setConferenceAddress(resultSet.getString(9));
            conference.setConferenceContent(resultSet.getString(10));
            conference.setConferenceStatus(resultSet.getString(11));
        }
        return conference;

    }

    private ArrayList<Conference> initConferenceTable(ResultSet resultSet) throws SQLException {
        ArrayList<Conference> conferences = new ArrayList<Conference>();
        while (resultSet.next()) {
            Conference conference = new Conference();
            conference.setConferenceId(resultSet.getLong(1));
            conference.setConferenceName(resultSet.getString(2));
            conference.setConferenceDescription(resultSet.getString(3));
            conference.setMaxNumberParticipants(resultSet.getInt(4));
            conference.setConferenceBeginning(resultSet.getTimestamp(5));
            conference.setConferenceEnd(resultSet.getTimestamp(6));
            conference.setConferenceCountry(resultSet.getString(7));
            conference.setConferenceCity(resultSet.getString(8));
            conference.setConferenceAddress(resultSet.getString(9));
            conference.setConferenceContent(resultSet.getString(10));
            conference.setConferenceStatus(resultSet.getString(11));
            conferences.add(conference);
        }
        return conferences;
    }
}
