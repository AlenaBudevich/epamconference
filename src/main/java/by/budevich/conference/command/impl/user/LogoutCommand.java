package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Asus on 29.01.2018.
 */
public class LogoutCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(LogoutCommand.class);

    public static LogoutCommand instance = new LogoutCommand();

    private LogoutCommand() {
    }

    public static LogoutCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        HttpSession session = request.getSession();
        session.invalidate();
        return ViewAllConferencesCommand.getInstance().getPage(request, response);
    }
}
