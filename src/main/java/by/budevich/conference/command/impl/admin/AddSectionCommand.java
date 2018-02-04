package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ConferenceService;
import by.budevich.conference.service.SectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 01.02.2018.
 */
public class AddSectionCommand implements BaseCommand {
    private static AddSectionCommand instance = new AddSectionCommand();

    private AddSectionCommand() {
    }

    public static AddSectionCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        String conferenceName = request.getParameter("conferenceName");
        if (ConferenceService.getInstance().findConferenceByName(conferenceName) != null) {
            Conference conference = ConferenceService.getInstance().findConferenceByName(conferenceName);
            long conferenceId = conference.getConferenceId();
            String sectionName = request.getParameter("sectionName");

            if (SectionService.getInstance().findSectionsByName(sectionName) == null) {

                SectionService.getInstance().addBasicSectionInfo(conferenceId, sectionName);
                request.setAttribute("conference", conference);
                return ViewAllConferencesCommand.getInstance().getPage(request, response);
            } else {
                return "jsp/error.jsp";
            }
        } else {
            return "jsp/error.jsp";
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        return "jsp/addsection.jsp";
    }
}
