package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
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
public class ViewProfileInfoCommand implements BaseCommand {
    public static ViewProfileInfoCommand instance = new ViewProfileInfoCommand();

    private ViewProfileInfoCommand() {
    }

    public static ViewProfileInfoCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, SQLException, DAOException {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServiceException, DAOException {
        if (request.getSession().getAttribute(AttributeConst.ATTR_USER_ID) != null) {
            long id = (Long) request.getSession().getAttribute(AttributeConst.ATTR_USER_ID);
            User user = UserService.getInstance().findUserById(id);
            request.setAttribute(AttributeConst.ATTR_EMAIL, user.getEmail());
            request.setAttribute(AttributeConst.ATTR_PHONE_NUMBER, user.getPhoneNumber());
            request.setAttribute(AttributeConst.ATTR_AVATAR, user.getAvatar());
            request.setAttribute(AttributeConst.ATTR_FIRST_NAME, user.getFirstName());
            request.setAttribute(AttributeConst.ATTR_LAST_NAME, user.getLastName());
            request.setAttribute(AttributeConst.ATTR_SURNAME, user.getSurname());
            return PageConst.PAGE_PROFILE;
        } else return PageConst.PAGE_ERROR;
    }
}
