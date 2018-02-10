package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.ErrorMessageConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ConferenceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 01.02.2018.
 */
public class AddConferenceCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(AddConferenceCommand.class);

    private static AddConferenceCommand instance = new AddConferenceCommand();

    private AddConferenceCommand() {
    }

    public static AddConferenceCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The execute() method is called");

        String conferenceName = request.getParameter(ParameterConst.PARAMETER_CONFERENCE_NAME);
        if (ConferenceService.getInstance().findConferenceByName(conferenceName).
                getConferenceName() == null) {
            Conference conference = new Conference();
            conference.setConferenceName(conferenceName);
            conference.setConferenceDescription(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_DESCRIPTION));
            conference.setConferenceCountry(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_COUNTRY));
            conference.setConferenceCity(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_CITY));
            ConferenceService.getInstance().addConference(conference);
            return ViewAllConferencesCommand.getInstance().getPage(request, response);
        }
        else {
            request.setAttribute(AttributeConst.ATTR_ERROR, ErrorMessageConst.ERROR_ADD_CONFERENCE);
            return PageConst.PAGE_ERROR;
        }

    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        return PageConst.PAGE_ADD_CONFERENCE;
    }
}
