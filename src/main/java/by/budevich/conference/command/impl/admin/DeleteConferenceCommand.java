package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ConferenceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 01.02.2018.
 */
public class DeleteConferenceCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(DeleteConferenceCommand.class);

    public static DeleteConferenceCommand instance = new DeleteConferenceCommand();

    private DeleteConferenceCommand() {}

    public static DeleteConferenceCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        String conferenceId = request.getParameter(ParameterConst.PARAMETER_CONFERENCE_ID);
        ConferenceService.getInstance().deleteConference(conferenceId);
        return ViewAllConferencesCommand.getInstance().getPage(request, response);
    }
}
