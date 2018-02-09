package by.budevich.conference.service;

import by.budevich.conference.dao.BaseConferenceDAO;
import by.budevich.conference.dao.impl.ConferenceDAO;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class ConferenceService {
    private BaseConferenceDAO dao;
    private static ConferenceService instance = new ConferenceService();

    private ConferenceService() {
        dao = new ConferenceDAO();
    }

    public static ConferenceService getInstance() {
        if(instance==null){
            instance = new ConferenceService();
        }
        return instance;
    }

    public void addConference(Conference conference) throws DAOException {
        dao.addConference(conference);
    }

    public void updateConferenceInfo(Conference conference) throws DAOException {
        dao.updateConferenceInfo(conference);
    }

    public void deleteConference(String conferenceId) throws DAOException {
        dao.deleteConference(Long.parseLong(conferenceId));
    }

    public ArrayList<Conference> showConferences() throws DAOException {
        return dao.showConferences();
    }

    public Conference findConferenceById(String conferenceId) throws DAOException {
        return dao.findConferenceById(Long.parseLong(conferenceId));
    }

    public Conference findConferenceByName(String conferenceName) throws DAOException {
        return dao.findConferenceByName(conferenceName);
    }

}
