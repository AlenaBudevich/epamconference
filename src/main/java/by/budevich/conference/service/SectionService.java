package by.budevich.conference.service;

import by.budevich.conference.dao.BaseSectionDAO;
import by.budevich.conference.dao.impl.SectionDAO;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class SectionService {
    private BaseSectionDAO dao;
    private static SectionService instance = new SectionService();

    private SectionService() {
        dao = SectionDAO.getInstance();
    }

    public static SectionService getInstance() {
        return instance;
    }

    public void addBasicSectionInfo(String conferenceId, String sectionName) throws ServiceException,
            SQLException, DAOException {
        try {
            Section section = new Section(Long.parseLong(conferenceId), sectionName);
            dao.addSectionInfo(section);
        } catch (DAOException e) {
            throw new ServiceException("Can't add section to a database ", e);
        }
    }

    public void updateSectionInfo(String sectionID, String conferenceID, String sectionName, String maxNumberReports,
                                  Timestamp sectionBeginning, Timestamp sectionEnd, String sectionAddress, String sectionContent)
            throws ServiceException, SQLException {
        try {
            Section section = new Section();
            section.setSectionId(Long.parseLong(sectionID));
            section.setConferenceId(Long.parseLong(conferenceID));
            section.setSectionName(sectionName);
            section.setMaxNumberReports(Integer.parseInt(maxNumberReports));
            section.setSectionBeginning(sectionBeginning);
            section.setSectionEnd(sectionEnd);
            section.setSectionAddress(sectionAddress);
            section.setSectionContent(sectionContent);
            dao.updateSectionInfo(section);
        } catch (DAOException e) {
            throw new ServiceException("Can't update section in service method ", e);
        }
    }

    public void assignStatusToSection(String sectionId, String sectionStatus) throws ServiceException, SQLException {
        try {
            dao.assignStatusToSection(Long.parseLong(sectionId), sectionStatus);
        } catch (DAOException e) {
            throw new ServiceException("Can't assign new status for section with id ", e);
        }
    }

    public void deleteSection(String sectionId) throws ServiceException, SQLException {
        try {
            dao.deleteSection(Long.parseLong(sectionId));
        } catch (DAOException e) {
            throw new ServiceException("Can't delete section in service method ", e);
        }
    }

    public void deleteSectionsByConference (String conferenceId) throws ServiceException, SQLException {
        try {
            dao.deleteSectionsByConference(Long.parseLong(conferenceId));
        } catch (DAOException e) {
            throw new ServiceException("Can't delete section in service method by such conferenceId", e);
        }
    }

    public ArrayList<Section> showSections() throws ServiceException, SQLException {
        try {
            return dao.showSections();
        } catch (DAOException e) {
            throw new ServiceException("Can't show section table ", e);
        }
    }

    public ArrayList<Section> showSectionsByConferenceId(String conferenceId) throws ServiceException, SQLException {
        try {
            return dao.showSectionsByConferenceId(Long.parseLong(conferenceId));
        } catch (DAOException e) {
            throw new ServiceException("Can't find section(s) with such conferenceId ", e);
        }
    }

    public ArrayList<Section> findSectionsByName(String sectionName) throws ServiceException, SQLException {
        try {
            return dao.findSectionsByName(sectionName);
        } catch (DAOException e) {
            throw new ServiceException("Can't find section(s) with such name ", e);
        }
    }

    public Section findSectionById(String sectionId) throws ServiceException, SQLException {
        try {
            return dao.findSectionById(Long.parseLong(sectionId));
        } catch (DAOException e) {
            throw new ServiceException("Can't find section with such id ", e);
        }
    }
}
