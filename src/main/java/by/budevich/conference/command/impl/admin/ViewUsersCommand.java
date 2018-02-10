package by.budevich.conference.command.impl.admin;

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
import java.util.ArrayList;

/**
 * Created by Asus on 31.01.2018.
 */
public class ViewUsersCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(ViewUsersCommand.class);

    public static ViewUsersCommand instance = new ViewUsersCommand();

    private ViewUsersCommand() {}

    public static ViewUsersCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        long userId = (Long)request.getSession().getAttribute("userId");
        ArrayList<User> users = UserService.getInstance().showUsers(userId);
        request.setAttribute(AttributeConst.ATTR_USERS, users);
        return PageConst.PAGE_VIEW_USERS;

    }
}
