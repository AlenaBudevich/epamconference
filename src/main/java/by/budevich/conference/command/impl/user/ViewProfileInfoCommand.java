package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 29.01.2018.
 */
public class ViewProfileInfoCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(ViewProfileInfoCommand.class);

    public static ViewProfileInfoCommand instance = new ViewProfileInfoCommand();

    private ViewProfileInfoCommand() {
    }

    public static ViewProfileInfoCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        long id = (Long) request.getSession().getAttribute(AttributeConst.ATTR_USER_ID);
        User user = UserService.getInstance().findUserById(id);
        request.setAttribute(AttributeConst.ATTR_EMAIL, user.getEmail());
        request.setAttribute(AttributeConst.ATTR_PHONE_NUMBER, user.getPhoneNumber());
        request.setAttribute(AttributeConst.ATTR_AVATAR, user.getAvatar());
        request.setAttribute(AttributeConst.ATTR_FIRST_NAME, user.getFirstName());
        request.setAttribute(AttributeConst.ATTR_LAST_NAME, user.getLastName());
        request.setAttribute(AttributeConst.ATTR_SURNAME, user.getSurname());
        return PageConst.PAGE_PROFILE;
    }
}
