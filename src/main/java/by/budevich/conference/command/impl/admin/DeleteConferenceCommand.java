package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 01.02.2018.
 */
public class DeleteConferenceCommand implements BaseCommand {
    public static DeleteConferenceCommand instance = new DeleteConferenceCommand();

    private DeleteConferenceCommand() {
    }

    public static DeleteConferenceCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        String conferenceId = request.getParameter("conferenceId");
        ConferenceService.getInstance().deleteConference(conferenceId);
        return ViewAllConferencesCommand.getInstance().getPage(request, response);
    }
}
