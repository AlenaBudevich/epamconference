package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.MessageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 31.01.2018.
 */
public class ChangeMessageCommand implements BaseCommand {
    public static ChangeMessageCommand instance = new ChangeMessageCommand();

    private ChangeMessageCommand() {
    }

    public static ChangeMessageCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        long messageId = Long.parseLong(request.getParameter("messageId"));
        Message message = MessageService.getInstance().findMessageById(messageId);
        message.setMessageText(request.getParameter("messageText"));
        message.setMessageContent(request.getParameter("messageContent"));
        MessageService.getInstance().updateSendedMessage(message);

        return ViewUserOutgoingMessagesCommand.getInstance().getPage(request, response);
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        long messageId = Long.parseLong(request.getParameter("messageId"));
        Message message = MessageService.getInstance().findMessageById(messageId);
        request.setAttribute("message", message);
        request.setAttribute("changeMessage", true);
        return ViewUserOutgoingMessagesCommand.getInstance().getPage(request, response);
    }
}
