package by.budevich.conference.controller;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.CommandEnum;
import by.budevich.conference.command.common.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Asus on 22.01.2018.
 */
public class CommandFactory {
    public BaseCommand defineCommand(HttpServletRequest request){
        BaseCommand command = EmptyCommand.getInstance();
        String action = request.getParameter("command");
        try{
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            command = currentEnum.getCurrentCommand();
        } catch(IllegalArgumentException e){
            //request.setAttribute(AttributeConst.ATTR_ERROR_MESSAGE, MessageConst.MESSAGE_WRONG_ACTION);
        }
        return command;
    }
}
