package by.budevich.conference.command.impl.common;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        String login = request.getParameter(ParameterConst.PARAMETER_LOGIN);
        String password = request.getParameter(ParameterConst.PARAMETER_PASSWORD);
        String email = request.getParameter(ParameterConst.PARAMETER_EMAIL);

        if (UserService.getInstance().findUserByLogin(login)!=null) {
            return PageConst.PAGE_ERROR;
        }
        else
        {
            UserService.getInstance().addUser(login, password, email);
            return PageConst.PAGE_LOGIN;
        }

    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute(AttributeConst.ATTR_USER_ID) != null) {
            return PageConst.PAGE_ERROR;
        }
        else {
            return PageConst.PAGE_REGISTRATION;
        }
    }
}
