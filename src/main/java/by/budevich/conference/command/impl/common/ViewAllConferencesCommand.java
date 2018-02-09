package by.budevich.conference.command.impl.common;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Asus on 28.01.2018.
 */
public class ViewAllConferencesCommand implements BaseCommand{
    public static ViewAllConferencesCommand instance = new ViewAllConferencesCommand();

    private ViewAllConferencesCommand() {
    }

    public static ViewAllConferencesCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        ArrayList<Conference> conferences= ConferenceService.getInstance().showConferences();
        request.setAttribute(AttributeConst.ATTR_CONFERENCES, conferences);
        return PageConst.PAGE_MAIN;
    }

}
