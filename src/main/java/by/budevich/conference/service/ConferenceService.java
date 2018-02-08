package by.budevich.conference.service;

import by.budevich.conference.dao.BaseConferenceDAO;
import by.budevich.conference.dao.impl.ConferenceDAO;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class ConferenceService {
    private BaseConferenceDAO dao;
    private static ConferenceService instance = new ConferenceService();

    private ConferenceService() {
        dao = ConferenceDAO.getInstance();
    }

    public static ConferenceService getInstance() {
        return instance;
    }

    public void addConference(Conference conference) throws DAOException, SQLException {
        dao.addConference(conference);
    }

    public void updateConferenceInfo(Conference conference) throws SQLException, DAOException {
        dao.updateConferenceInfo(conference);
    }

    public void deleteConference(String conferenceId) throws SQLException, DAOException {
        dao.deleteConference(Long.parseLong(conferenceId));
    }

    public ArrayList<Conference> showConferences() throws SQLException, DAOException {
        return dao.showConferences();
    }

    public Conference findConferenceById(String conferenceId) throws SQLException, DAOException {
        return dao.findConferenceById(Long.parseLong(conferenceId));
    }

    public Conference findConferenceByName(String conferenceName) throws SQLException, DAOException {
        return dao.findConferenceByName(conferenceName);
    }

}
