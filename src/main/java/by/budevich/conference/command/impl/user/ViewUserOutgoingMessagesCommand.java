package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.MessageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String execute(HttpServletRequest request, HttpServletResponse response){
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        if (request.getSession().getAttribute(AttributeConst.ATTR_USER_ID) != null) {
            long id = (Long) request.getSession().getAttribute(AttributeConst.ATTR_USER_ID);
            ArrayList<Message> userMessages = MessageService.getInstance().showOutgoingMessagesByUserId(id);
            request.setAttribute(AttributeConst.ATTR_MESSAGES, userMessages);
            return PageConst.PAGE_OUTGOING_MESSAGES;
        } else {
            return PageConst.PAGE_ERROR;
        }
    }
}
