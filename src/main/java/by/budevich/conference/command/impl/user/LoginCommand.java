package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 22.01.2018.
 */
public class LoginCommand implements BaseCommand{
    public static LoginCommand instance = new LoginCommand();
    private LoginCommand(){}

    public static LoginCommand getInstance () {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = UserService.getInstance().findUserByLogin(login);
        if (user==null) return "jsp/error.jsp";
        if (user.getPassword().equals(password)) {
            request.getSession().setAttribute("login", user.getLogin());
            request.getSession().setAttribute("role", user.getRole());
            request.getSession().setAttribute("userId", user.getUserId());
            return ViewAllConferencesCommand.getInstance().getPage(request,response);
        }
        else return "jsp/error.jsp";
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        if (request.getSession().getAttribute("userId") != null) {
            return "jsp/error.jsp";
        }
        else {
            return "jsp/login.jsp";
        }

    }
}
