package by.budevich.conference.service;

import by.budevich.conference.dao.BaseConferenceDAO;
import by.budevich.conference.dao.impl.ConferenceDAO;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;

import java.sql.SQLException;
import java.sql.Timestamp;
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

    public void updateConferenceInfo(String  conferenceId, String conferenceName, String conferenceDescription,
                                     String maxNumberParticipants, Timestamp conferenceBeginning, Timestamp conferenceEnd,
                                     String conferenceCountry, String conferenceCity, String conferenceAddress,
                                     String conferenceContent)
            throws ServiceException, SQLException {
        Conference conference = new Conference();
        conference.setConferenceId(Long.parseLong(conferenceId));
        conference.setConferenceName(conferenceName);
        conference.setConferenceDescription(conferenceDescription);
        conference.setMaxNumberParticipants(Integer.parseInt(maxNumberParticipants));
        conference.setConferenceBeginning(conferenceBeginning);
        conference.setConferenceEnd(conferenceEnd);
        conference.setConferenceCountry(conferenceCountry);
        conference.setConferenceCity(conferenceCity);
        conference.setConferenceAddress(conferenceAddress);
        conference.setConferenceContent(conferenceContent);
        dao.updateConferenceInfo(conference);
    }

    public void assignStatusToConference(String conferenceId, String conferenceStatus) throws ServiceException, SQLException {
        dao.assignStatusToConference(Long.parseLong(conferenceId), conferenceStatus);
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
