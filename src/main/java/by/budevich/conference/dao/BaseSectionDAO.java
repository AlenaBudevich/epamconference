package by.budevich.conference.dao;

import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 24.01.2018.
 */
public interface BaseSectionDAO {
    void addSectionInfo(Section section) throws DAOException, SQLException;
    void updateSectionInfo(Section section) throws DAOException, SQLException;
    void assignStatusToSection(long sectionId, String sectionStatus) throws DAOException, SQLException;
    void deleteSection(long sectionId) throws DAOException, SQLException;
    void deleteSectionsByConference(long conferenceId) throws DAOException, SQLException;
    ArrayList<Section> showSections() throws DAOException, SQLException;
    ArrayList<Section> showSectionsByConferenceId(long conferenceId) throws DAOException, SQLException;
    Section findSectionById(long sectionId) throws DAOException, SQLException;
    ArrayList<Section> findSectionsByName (String sectionName) throws DAOException, SQLException;
}
