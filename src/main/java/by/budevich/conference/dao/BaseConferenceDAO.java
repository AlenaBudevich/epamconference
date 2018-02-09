package by.budevich.conference.dao;

import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public interface BaseConferenceDAO {
    void addConference(Conference conference) throws DAOException;
    void updateConferenceInfo(Conference conference) throws DAOException;
    void deleteConference(long conferenceId) throws DAOException;
    ArrayList<Conference> showConferences() throws DAOException;
    Conference findConferenceById(long conferenceId) throws DAOException;
    Conference findConferenceByName(String conferenceName) throws DAOException;
}
