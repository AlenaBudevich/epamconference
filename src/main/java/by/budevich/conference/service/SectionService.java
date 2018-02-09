package by.budevich.conference.service;

import by.budevich.conference.dao.BaseSectionDAO;
import by.budevich.conference.dao.impl.SectionDAO;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public class SectionService {
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

    public void addBasicSectionInfo(long conferenceId, String sectionName) throws DAOException {
        Section section = new Section(conferenceId, sectionName);
        dao.addSectionInfo(section);
    }

    public void updateSectionInfo(Section section) throws DAOException {
        dao.updateSectionInfo(section);
    }

    public void deleteSection(String sectionId) throws DAOException {
        dao.deleteSection(Long.parseLong(sectionId));
    }

    public ArrayList<Section> showSections() throws DAOException {
        return dao.showSections();
    }

    public ArrayList<Section> showSectionsByConferenceId(String conferenceId) throws DAOException {
        return dao.showSectionsByConferenceId(Long.parseLong(conferenceId));
    }

    public Section findSectionsByName(String sectionName) throws DAOException {
        return dao.findSectionByName(sectionName);
    }

    public Section findSectionById(String sectionId) throws DAOException {
        return dao.findSectionById(Long.parseLong(sectionId));
    }
}
