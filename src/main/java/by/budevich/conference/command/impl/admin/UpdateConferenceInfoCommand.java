package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
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

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        String conferenceId = request.getParameter("conferenceId");
        Conference conference = ConferenceService.getInstance().findConferenceById(conferenceId);
        String conferenceName = request.getParameter("conferenceName");
        if (ConferenceService.getInstance().findConferenceByName(conferenceName) == null ||
                conferenceName.equals(conference.getConferenceName())) {
            conference.setConferenceName(conferenceName);
            conference.setConferenceDescription(request.getParameter("conferenceDescription"));
            int maxNumberParticipants = Integer.parseInt(request.getParameter("maxNumberParticipants"));
            conference.setMaxNumberParticipants(maxNumberParticipants);
            Timestamp conferenceBeginning = Timestamp.valueOf(request.getParameter("conferenceBeginning"));
            conference.setConferenceBeginning(conferenceBeginning);
            Timestamp conferenceEnd = Timestamp.valueOf(request.getParameter("conferenceEnd"));
            conference.setConferenceBeginning(conferenceEnd);
            conference.setConferenceCountry(request.getParameter("conferenceCountry"));
            conference.setConferenceCity(request.getParameter("conferenceCity"));
            conference.setConferenceAddress(request.getParameter("conferenceAddress"));
            conference.setConferenceContent(request.getParameter("conferenceContent"));
            conference.setConferenceStatus(request.getParameter("conferenceStatus"));

            ConferenceService.getInstance().updateConferenceInfo(conference);

            return ViewAllConferencesCommand.getInstance().getPage(request, response);
        }
        else{
            return "jsp/error.jsp";
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        String conferenceId = request.getParameter("conferenceId");
        Conference conference = ConferenceService.getInstance().findConferenceById(conferenceId);
        request.setAttribute("conference", conference);
        return "jsp/updateconferenceinfo.jsp";
    }
}
