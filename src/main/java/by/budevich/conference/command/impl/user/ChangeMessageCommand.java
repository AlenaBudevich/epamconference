package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 31.01.2018.
 */
public class ChangeMessageCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(ChangeMessageCommand.class);

    public static ChangeMessageCommand instance = new ChangeMessageCommand();

    private ChangeMessageCommand() {}

    public static ChangeMessageCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The execute() method is called");

        long messageId = Long.parseLong(request.getParameter(ParameterConst.PARAMETER_MESSAGE_ID));
        Message message = MessageService.getInstance().findMessageById(messageId);
        message.setMessageText(request.getParameter(ParameterConst.PARAMETER_MESSAGE_TEXT));
        message.setMessageContent(request.getParameter(ParameterConst.PARAMETER_MESSAGE_CONTENT));
        MessageService.getInstance().updateSendedMessage(message);

        return ViewUserOutgoingMessagesCommand.getInstance().getPage(request, response);
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        long messageId = Long.parseLong(request.getParameter(ParameterConst.PARAMETER_MESSAGE_ID));
        Message message = MessageService.getInstance().findMessageById(messageId);
        request.setAttribute(AttributeConst.ATTR_MESSAGE, message);
        request.setAttribute(AttributeConst.ATTR_CHANGE_MESSAGE, true);
        return ViewUserOutgoingMessagesCommand.getInstance().getPage(request, response);
    }
}
