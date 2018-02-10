package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        long id = (Long) request.getSession().getAttribute(AttributeConst.ATTR_USER_ID);
        User user = UserService.getInstance().findUserById(id);
        user.setEmail(request.getParameter(ParameterConst.PARAMETER_EMAIL));
        if  (!request.getParameter(ParameterConst.PARAMETER_PHONE_NUMBER).equals("")) {
            user.setPhoneNumber(Integer.parseInt(request.getParameter(ParameterConst.PARAMETER_PHONE_NUMBER)));
        }
        else {
            user.setPhoneNumber(0);
        }
        user.setAvatar(request.getParameter(ParameterConst.PARAMETER_AVATAR));
        user.setFirstName(request.getParameter(ParameterConst.PARAMETER_FIRST_NAME));
        user.setLastName(request.getParameter(ParameterConst.PARAMETER_LAST_NAME));
        user.setSurname(request.getParameter(ParameterConst.PARAMETER_SURNAME));
        UserService.getInstance().updateUserInfo(user);
        return ViewProfileInfoCommand.getInstance().getPage(request,response);
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        long id = (Long) request.getSession().getAttribute(AttributeConst.ATTR_USER_ID);
        User user = UserService.getInstance().findUserById(id);
        request.setAttribute(AttributeConst.ATTR_EMAIL, user.getEmail());
        request.setAttribute(AttributeConst.ATTR_PHONE_NUMBER, user.getPhoneNumber());
        request.setAttribute(AttributeConst.ATTR_AVATAR, user.getAvatar());
        request.setAttribute(AttributeConst.ATTR_FIRST_NAME, user.getFirstName());
        request.setAttribute(AttributeConst.ATTR_LAST_NAME, user.getLastName());
        request.setAttribute(AttributeConst.ATTR_SURNAME, user.getSurname());
        return PageConst.PAGE_CHANGE_PROFILE;
    }
}
