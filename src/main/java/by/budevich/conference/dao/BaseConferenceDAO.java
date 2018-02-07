package by.budevich.conference.dao;

import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public interface BaseConferenceDAO {
    void addConference(Conference conference) throws SQLException, DAOException;
    void updateConferenceInfo(Conference conference) throws SQLException, DAOException;
    void deleteConference(long conferenceId) throws SQLException, DAOException;
    ArrayList<Conference> showConferences() throws SQLException, DAOException;
    Conference findConferenceById(long conferenceId) throws SQLException, DAOException;
    Conference findConferenceByName(String conferenceName) throws SQLException, DAOException;
}
