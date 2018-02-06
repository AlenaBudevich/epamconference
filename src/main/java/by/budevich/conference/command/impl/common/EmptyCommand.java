package by.budevich.conference.command.impl.common;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.PageConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 22.01.2018.
 */
public class EmptyCommand implements BaseCommand {
    private static EmptyCommand instance = new EmptyCommand();

    private EmptyCommand() {
    }

    public static EmptyCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageConst.PAGE_INDEX;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }


}
