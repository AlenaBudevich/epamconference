package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.MessageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 31.01.2018.
 */
public class DeleteMessageCommand implements BaseCommand {
    public static DeleteMessageCommand instance = new DeleteMessageCommand();

    private DeleteMessageCommand() {
    }

    public static DeleteMessageCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        long messageId = Long.parseLong(request.getParameter(ParameterConst.PARAMETER_MESSAGE_ID));
        MessageService.getInstance().deleteMessage(messageId);
        return ViewUserIncomingMessagesCommand.getInstance().getPage(request, response);
    }
}
