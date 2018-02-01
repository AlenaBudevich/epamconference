package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.SectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by Asus on 01.02.2018.
 */
public class UpdateSectionInfoCommand implements BaseCommand {
    public static UpdateSectionInfoCommand instance = new UpdateSectionInfoCommand();

    private UpdateSectionInfoCommand() {
    }

    public static UpdateSectionInfoCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, SQLException, DAOException {
        String sectionId = request.getParameter("sectionId");
        Section section = SectionService.getInstance().findSectionById(sectionId);
        section.setSectionName(request.getParameter("sectionName"));
        int maxNumberReports = Integer.parseInt(request.getParameter("maxNumberReports"));
        section.setMaxNumberReports(maxNumberReports);
        Timestamp sectionBeginning = Timestamp.valueOf(request.getParameter("sectionBeginning"));
        section.setSectionBeginning(sectionBeginning);
        Timestamp sectionEnd = Timestamp.valueOf(request.getParameter("sectionEnd"));
        section.setSectionEnd(sectionEnd);
        section.setSectionAddress(request.getParameter("sectionAddress"));
        section.setSectionContent(request.getParameter("sectionContent"));
        section.setSectionStatus(request.getParameter("sectionStatus"));

        SectionService.getInstance().updateSectionInfo(section);
        return ViewAllConferencesCommand.getInstance().getPage(request, response);
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServiceException, DAOException {
        String sectionId = request.getParameter("sectionId");
        Section section = SectionService.getInstance().findSectionById(sectionId);
        request.setAttribute("section", section);
        return "jsp/updatesectioninfo.jsp";
    }
}
