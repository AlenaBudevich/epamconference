package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.MessageService;
import by.budevich.conference.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 31.01.2018.
 */
public class SendMessageCommand implements BaseCommand {
    public static SendMessageCommand instance = new SendMessageCommand();

    private SendMessageCommand() {
    }

    public static SendMessageCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, SQLException, DAOException {

        long sendId = (Long) request.getSession().getAttribute("userId");
        String login = request.getParameter("login");
        if (UserService.getInstance().findUserByLogin(login) != null) {
            long receiveId = UserService.getInstance().findUserByLogin(login).getUserId();
            String messageText = request.getParameter("messageText");
            Message message = new Message();
            message.setSendId(sendId);
            message.setReceiveId(receiveId);
            message.setMessageText(messageText);
            message.setMessageContent(request.getParameter("messageContent"));
            MessageService.getInstance().sendMessage(message);
            return ViewUserOutgoingMessagesCommand.getInstance().getPage(request, response);

        } else {
            return "jsp/error.jsp";
        }

    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        request.setAttribute("sendMessage", true);
        return ViewUserOutgoingMessagesCommand.getInstance().getPage(request, response);
    }
}
