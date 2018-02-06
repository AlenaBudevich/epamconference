package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by Asus on 01.02.2018.
 */
public class UpdateConferenceInfoCommand implements BaseCommand {
    public static UpdateConferenceInfoCommand instance = new UpdateConferenceInfoCommand();

    private UpdateConferenceInfoCommand() {
    }

    public static UpdateConferenceInfoCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, SQLException, DAOException {
        String conferenceId = request.getParameter(ParameterConst.PARAMETER_CONFERENCE_ID);
        Conference conference = ConferenceService.getInstance().findConferenceById(conferenceId);
        String conferenceName = request.getParameter(ParameterConst.PARAMETER_CONFERENCE_NAME);
        if (ConferenceService.getInstance().findConferenceByName(conferenceName) == null ||
                conferenceName.equals(conference.getConferenceName())) {
            conference.setConferenceName(conferenceName);
            conference.setConferenceDescription(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_DESCRIPTION));
            int maxNumberParticipants = Integer.parseInt(request.getParameter(ParameterConst.PARAMETER_MAX_NUMBER_PARTICIPANTS));
            conference.setMaxNumberParticipants(maxNumberParticipants);
            Timestamp conferenceBeginning = Timestamp.valueOf(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_BEGINNING));
            conference.setConferenceBeginning(conferenceBeginning);
            Timestamp conferenceEnd = Timestamp.valueOf(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_END));
            conference.setConferenceBeginning(conferenceEnd);
            conference.setConferenceCountry(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_COUNTRY));
            conference.setConferenceCity(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_CITY));
            conference.setConferenceAddress(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_ADDRESS));
            conference.setConferenceContent(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_CONTENT));
            conference.setConferenceStatus(request.getParameter(ParameterConst.PARAMETER_CONFERENCE_STATUS));

            ConferenceService.getInstance().updateConferenceInfo(conference);

            return ViewAllConferencesCommand.getInstance().getPage(request, response);
        }
        else{
            return PageConst.PAGE_ERROR;
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServiceException, DAOException {
        String conferenceId = request.getParameter(ParameterConst.PARAMETER_CONFERENCE_ID);
        Conference conference = ConferenceService.getInstance().findConferenceById(conferenceId);
        request.setAttribute(AttributeConst.ATTR_CONFERENCE, conference);
        return PageConst.PAGE_UPDATE_CONFERENCE_INFO;
    }
}
