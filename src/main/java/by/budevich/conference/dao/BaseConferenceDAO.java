package by.budevich.conference.dao;

import by.budevich.conference.entity.Conference;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public interface BaseConferenceDAO {
    void addConference(Conference conference) throws SQLException;
    void updateConferenceInfo(Conference conference) throws SQLException;
    void assignStatusToConference(long conferenceId, String conferenceStatus) throws SQLException;
    void deleteConference(long conferenceId) throws SQLException;
    ArrayList<Conference> showConferences() throws SQLException;
    Conference findConferenceById(long conferenceId) throws SQLException;
    Conference findConferenceByName(String conferenceName) throws SQLException;
}
