package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.MessageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 31.01.2018.
 */
public class ViewUserOutgoingMessagesCommand implements BaseCommand {
    public static ViewUserOutgoingMessagesCommand instance = new ViewUserOutgoingMessagesCommand();

    private ViewUserOutgoingMessagesCommand() {
    }

    public static ViewUserOutgoingMessagesCommand getInstance() {
        return instance;
    }
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, SQLException, DAOException {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServiceException, DAOException {
        if (request.getSession().getAttribute("userId") != null) {
            long id = (Long) request.getSession().getAttribute("userId");
            ArrayList<Message> userMessages = MessageService.getInstance().showOutgoingMessagesByUserId(id);
            request.setAttribute("messages", userMessages);
            return "jsp/outgoingmessages.jsp";
        } else {
            return "jsp/error.jsp";
        }
    }
}
