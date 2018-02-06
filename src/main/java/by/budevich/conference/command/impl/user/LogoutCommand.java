package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by Asus on 29.01.2018.
 */
public class LogoutCommand implements BaseCommand {
    public static LogoutCommand instance = new LogoutCommand();
    private LogoutCommand(){}

    public static LogoutCommand getInstance () {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, SQLException, DAOException {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServiceException, DAOException {
        if (request.getSession().getAttribute(AttributeConst.ATTR_USER_ID) != null){
            HttpSession session = request.getSession();
            session.invalidate();
            return ViewAllConferencesCommand.getInstance().getPage(request,response);
        }
        else return PageConst.PAGE_ERROR;
    }
}
