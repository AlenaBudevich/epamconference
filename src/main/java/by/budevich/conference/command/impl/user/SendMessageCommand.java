package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
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

        long sendId = (Long) request.getSession().getAttribute(AttributeConst.ATTR_USER_ID);
        String login = request.getParameter(ParameterConst.PARAMETER_LOGIN);
        if (UserService.getInstance().findUserByLogin(login) != null) {
            long receiveId = UserService.getInstance().findUserByLogin(login).getUserId();
            String messageText = request.getParameter(ParameterConst.PARAMETER_MESSAGE_TEXT);
            Message message = new Message();
            message.setSendId(sendId);
            message.setReceiveId(receiveId);
            message.setMessageText(messageText);
            message.setMessageContent(request.getParameter(ParameterConst.PARAMETER_MESSAGE_CONTENT));
            MessageService.getInstance().sendMessage(message);
            return ViewUserOutgoingMessagesCommand.getInstance().getPage(request, response);

        } else {
            return PageConst.PAGE_ERROR;
        }

    }

    public String getPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServiceException, DAOException {
        request.setAttribute(AttributeConst.ATTR_SEND_MESSAGE, true);
        return ViewUserOutgoingMessagesCommand.getInstance().getPage(request, response);
    }
}
