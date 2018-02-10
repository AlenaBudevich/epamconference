package by.budevich.conference.controller;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.CommandEnum;
import by.budevich.conference.command.impl.common.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Asus on 22.01.2018.
 */
public class CommandFactory {
    static final Logger LOGGER = LogManager.getLogger(CommandFactory.class);

    public BaseCommand defineCommand(HttpServletRequest request){
        LOGGER.info("The defineCommand() method is called");

        BaseCommand command = EmptyCommand.getInstance();
        String action = request.getParameter("command");
        try{
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            command = currentEnum.getCurrentCommand();
        } catch(IllegalArgumentException e){
            LOGGER.error("IllegalArgumentException occurred while defining a command");
        }
        return command;
    }
}
