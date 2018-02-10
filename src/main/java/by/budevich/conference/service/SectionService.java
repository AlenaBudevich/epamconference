package by.budevich.conference.service;

import by.budevich.conference.dao.BaseSectionDAO;
import by.budevich.conference.dao.impl.SectionDAO;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class SectionService {
    static final Logger LOGGER = LogManager.getLogger(SectionService.class);

    private BaseSectionDAO dao;
    private static SectionService instance = new SectionService();

    private SectionService() {
        dao = new SectionDAO();
    }

    public static SectionService getInstance() {
        if(instance==null){
            instance = new SectionService();
        }
        return instance;
    }

    public void addBasicSectionInfo(long conferenceName, String sectionName) throws DAOException {
        LOGGER.info("The addBasicSectionInfo() method is called with the input data:" + conferenceName + ", "+sectionName);
        Section section = new Section(conferenceName, sectionName);
        dao.addSectionInfo(section);
    }

    public void updateSectionInfo(Section section) throws DAOException {
        LOGGER.info("The updateSectionInfo() method is called with the input data:" + section.toString());
        dao.updateSectionInfo(section);
    }

    public void deleteSection(String sectionId) throws DAOException {
        LOGGER.info("The deleteSection() method is called with the input data:" + sectionId);
        dao.deleteSection(Long.parseLong(sectionId));
    }

    public ArrayList<Section> showSections() throws DAOException {
        LOGGER.info("The showSections() method is called");
        return dao.showSections();
    }

    public ArrayList<Section> showSectionsByConferenceId(String conferenceId) throws DAOException {
        LOGGER.info("The showSectionsByConferenceId() method is called with the input data:" + conferenceId);
        return dao.showSectionsByConferenceId(Long.parseLong(conferenceId));
    }

    public Section findSectionsByName(String sectionName) throws DAOException {
        LOGGER.info("The findSectionsByName() method is called with the input data:" +sectionName);
        return dao.findSectionByName(sectionName);
    }

    public Section findSectionById(String sectionId) throws DAOException {
        LOGGER.info("The findSectionById() method is called with the input data:" + sectionId);
        return dao.findSectionById(Long.parseLong(sectionId));
    }
}
