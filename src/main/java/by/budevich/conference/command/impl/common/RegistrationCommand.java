package by.budevich.conference.command.impl.common;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 22.01.2018.
 */
public class RegistrationCommand implements BaseCommand {
    public static RegistrationCommand instance = new RegistrationCommand();

    private RegistrationCommand() {
    }

    public static RegistrationCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if (UserService.getInstance().findUserByLogin(login)!=null) {
            return "jsp/error.jsp";
        }
        else
        {
            UserService.getInstance().addUser(login, password, email);
            return "jsp/login.jsp";}

    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException {
        if (request.getSession().getAttribute("userId") != null) {
            return "jsp/error.jsp";
        }
        else {
            return "jsp/registration.jsp";
        }
    }

}
