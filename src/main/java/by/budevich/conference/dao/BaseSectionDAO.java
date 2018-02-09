package by.budevich.conference.dao;

import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public interface BaseSectionDAO {
    void addSectionInfo(Section section) throws DAOException;
    void updateSectionInfo(Section section) throws DAOException;
    void deleteSection(long sectionId) throws DAOException;
    ArrayList<Section> showSections() throws DAOException;
    ArrayList<Section> showSectionsByConferenceId(long conferenceId) throws DAOException;
    Section findSectionById(long sectionId) throws DAOException;
    Section findSectionByName (String sectionName) throws DAOException;
}
