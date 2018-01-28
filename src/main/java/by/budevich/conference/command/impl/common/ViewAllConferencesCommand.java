package by.budevich.conference.command.impl.common;

import by.budevich.conference.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 28.01.2018.
 */
public class ViewAllConferencesCommand {
    public static ViewAllConferencesCommand instance = new ViewAllConferencesCommand();

    private ViewAllConferencesCommand() {
    }

    public static ViewAllConferencesCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException {
        String page = null;
        return page;
    }

}
