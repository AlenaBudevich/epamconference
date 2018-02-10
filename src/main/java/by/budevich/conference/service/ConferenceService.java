package by.budevich.conference.service;

import by.budevich.conference.dao.BaseConferenceDAO;
import by.budevich.conference.dao.impl.ConferenceDAO;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class ConferenceService {
    static final Logger LOGGER = LogManager.getLogger(ConferenceService.class);

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
        LOGGER.info("The addConference() method is called with the input data:" + conference.toString());
        dao.addConference(conference);
    }

    public void updateConferenceInfo(Conference conference) throws DAOException {
        LOGGER.info("The updateConferenceInfo() method is called with the input data:" + conference.toString());
        dao.updateConferenceInfo(conference);
    }

    public void deleteConference(String conferenceId) throws DAOException {
        LOGGER.info("The deleteConference() method is called with the input data:" + conferenceId);
        dao.deleteConference(Long.parseLong(conferenceId));
    }

    public ArrayList<Conference> showConferences() throws DAOException {
        LOGGER.info("The showConferences() method is called");
        return dao.showConferences();
    }

    public Conference findConferenceById(String conferenceId) throws DAOException {
        LOGGER.info("The findConferenceById() method is called with the input data:" + conferenceId);
        return dao.findConferenceById(Long.parseLong(conferenceId));
    }

    public Conference findConferenceByName(String conferenceName) throws DAOException {
        LOGGER.info("The findConferenceByName() method is called with the input data:" + conferenceName);
        return dao.findConferenceByName(conferenceName);
    }

}
