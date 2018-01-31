package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ConferenceService;
import by.budevich.conference.service.SectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 31.01.2018.
 */
public class ViewConferenceSectionsCommand implements BaseCommand {
    public static ViewConferenceSectionsCommand instance = new ViewConferenceSectionsCommand();

    private ViewConferenceSectionsCommand() {
    }

    public static ViewConferenceSectionsCommand getInstance() {
        return instance;
    }
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        String conferenceId = request.getParameter("conferenceId");
        Conference conference = ConferenceService.getInstance().findConferenceById(conferenceId);
        ArrayList<Section> conferenceSections = SectionService.getInstance().showSectionsByConferenceId(conferenceId);
        request.setAttribute("conference", conference);
        request.setAttribute("sections", conferenceSections);
        return "jsp/conference.jsp";
    }
}
