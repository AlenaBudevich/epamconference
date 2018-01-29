package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 29.01.2018.
 */
public class ChangeProfileInfoCommand implements BaseCommand {
    public static ChangeProfileInfoCommand instance = new ChangeProfileInfoCommand();

    private ChangeProfileInfoCommand() {
    }

    public static ChangeProfileInfoCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        long id = (Long) request.getSession().getAttribute("userId");
        User user = UserService.getInstance().findUserById(id);
        user.setEmail(request.getParameter("email"));
        user.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
        user.setAvatar(request.getParameter("avatar"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setSurname(request.getParameter("surname"));
        UserService.getInstance().updateUserInfo(user);
        return ViewProfileInfoCommand.getInstance().getPage(request,response);
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        long id = (Long) request.getSession().getAttribute("userId");
        User user = UserService.getInstance().findUserById(id);
        request.setAttribute("email", user.getEmail());
        request.setAttribute("phoneNumber", user.getPhoneNumber());
        request.setAttribute("avatar", user.getAvatar());
        request.setAttribute("firstName", user.getFirstName());
        request.setAttribute("lastName", user.getLastName());
        request.setAttribute("surname", user.getSurname());
        return "jsp/changeprofile.jsp";
    }
}
