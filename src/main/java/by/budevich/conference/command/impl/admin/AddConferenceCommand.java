package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 01.02.2018.
 */
public class AddConferenceCommand implements BaseCommand {
    private static AddConferenceCommand instance = new AddConferenceCommand();

    private AddConferenceCommand() {
    }

    public static AddConferenceCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, SQLException, DAOException {
        String conferenceName = request.getParameter(ParameterConst.PARAMETER_CONFERENCE_NAME);
        if (ConferenceService.getInstance().findConferenceByName(conferenceName) == null) {
            Conference conference = new Conference();
            conference.setConferenceName(conferenceName);
            conference.setConferenceDescription(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_DESCRIPTION));
            conference.setConferenceCountry(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_COUNTRY));
            conference.setConferenceCity(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_CITY));
            ConferenceService.getInstance().addConference(conference);
            return ViewAllConferencesCommand.getInstance().getPage(request, response);
        }
        else {
            return PageConst.PAGE_ERROR;
        }

    }

    public String getPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServiceException, DAOException {
        return PageConst.PAGE_ADD_CONFERENCE;
    }
}
