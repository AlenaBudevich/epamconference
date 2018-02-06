package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 31.01.2018.
 */
public class AssignUserRoleCommand implements BaseCommand{
    public static AssignUserRoleCommand instance = new AssignUserRoleCommand();

    private AssignUserRoleCommand() {
    }

    public static AssignUserRoleCommand getInstance() {
        return instance;
    }
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, SQLException, DAOException {
        long userId = Long.parseLong(request.getParameter(ParameterConst.PARAMETER_USER_ID));
        String role = request.getParameter(ParameterConst.PARAMETER_ROLE);
        UserService.getInstance().assignRoleToUser(userId, role);

        return ViewUsersCommand.getInstance().getPage(request, response);
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServiceException, DAOException {
        long userId = Long.parseLong(request.getParameter(ParameterConst.PARAMETER_CHANGE_ID));
        request.setAttribute(AttributeConst.ATTR_CHANGE_ID, userId);
        return ViewUsersCommand.getInstance().getPage(request, response);
    }
}
