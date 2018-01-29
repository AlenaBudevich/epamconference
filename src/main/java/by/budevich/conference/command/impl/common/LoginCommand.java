package by.budevich.conference.command.impl.common;

import by.budevich.conference.command.BaseCommand;
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
    public static LoginCommand instance = new LoginCommand ();
    private LoginCommand (){}

    public static LoginCommand getInstance () {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = UserService.getInstance().findUserByLogin(login);
        if (user==null) return "jsp/error.jsp";
        if (user.getPassword().equals(password)) return "jsp/main.jsp";
        else return "jsp/Bad.jsp";
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        String page = "jsp/login.jsp";
        return page;
    }
}
