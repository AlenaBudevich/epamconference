package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.ErrorMessageConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.UserService;
import by.budevich.conference.util.SHA256Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 22.01.2018.
 */
public class LoginCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);

    public static LoginCommand instance = new LoginCommand();

    private LoginCommand() {
    }

    public static LoginCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The execute() method is called");

        String login = request.getParameter(ParameterConst.PARAMETER_LOGIN);
        String password = request.getParameter(ParameterConst.PARAMETER_PASSWORD);
        User user = UserService.getInstance().findUserByLogin(login);
        if (user.getLogin() == null) {
            request.setAttribute(AttributeConst.ATTR_ERROR, ErrorMessageConst.ERROR_LOGIN);
            return PageConst.PAGE_ERROR;
        }
        if (user.getPassword().equals(SHA256Util.encrypt(password))) {
            request.getSession().setAttribute(AttributeConst.ATTR_LOGIN, user.getLogin());
            request.getSession().setAttribute(AttributeConst.ATTR_ROLE, user.getRole());
            request.getSession().setAttribute(AttributeConst.ATTR_USER_ID, user.getUserId());
            return ViewAllConferencesCommand.getInstance().getPage(request, response);
        } else {
            request.setAttribute(AttributeConst.ATTR_ERROR, ErrorMessageConst.ERROR_PASSWORD);
            return PageConst.PAGE_ERROR;
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");
        return PageConst.PAGE_LOGIN;
    }
}
