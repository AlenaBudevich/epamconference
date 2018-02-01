package by.budevich.conference.service;

import by.budevich.conference.dao.BaseConferenceDAO;
import by.budevich.conference.dao.impl.ConferenceDAO;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;

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

    public void addConference(Conference conference) throws ServiceException, SQLException, DAOException {
        dao.addConference(conference);
    }

    public void updateConferenceInfo(Conference conference) throws ServiceException, SQLException {
        dao.updateConferenceInfo(conference);
    }

    public void deleteConference(String conferenceId) throws ServiceException, SQLException {
        dao.deleteConference(Long.parseLong(conferenceId));
    }

    public ArrayList<Conference> showConferences() throws ServiceException, SQLException {
        return dao.showConferences();
    }

    public Conference findConferenceById(String conferenceId) throws ServiceException, SQLException {
        return dao.findConferenceById(Long.parseLong(conferenceId));
    }

    public Conference findConferenceByName(String conferenceName) throws ServiceException, SQLException {
        return dao.findConferenceByName(conferenceName);
    }

}
