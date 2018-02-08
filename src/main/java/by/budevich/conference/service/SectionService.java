package by.budevich.conference.service;

import by.budevich.conference.dao.BaseSectionDAO;
import by.budevich.conference.dao.impl.SectionDAO;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;

import java.sql.SQLException;
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

    public void addBasicSectionInfo(long conferenceId, String sectionName) throws SQLException, DAOException {
        Section section = new Section(conferenceId, sectionName);
        dao.addSectionInfo(section);
    }

    public void updateSectionInfo(Section section) throws SQLException, DAOException {
        dao.updateSectionInfo(section);
    }

    public void deleteSection(String sectionId) throws SQLException, DAOException {
        dao.deleteSection(Long.parseLong(sectionId));
    }

    public ArrayList<Section> showSections() throws SQLException, DAOException {
        return dao.showSections();
    }

    public ArrayList<Section> showSectionsByConferenceId(String conferenceId) throws SQLException, DAOException {
        return dao.showSectionsByConferenceId(Long.parseLong(conferenceId));
    }

    public Section findSectionsByName(String sectionName) throws SQLException, DAOException {
        return dao.findSectionByName(sectionName);
    }

    public Section findSectionById(String sectionId) throws SQLException, DAOException {
        return dao.findSectionById(Long.parseLong(sectionId));
    }
}
