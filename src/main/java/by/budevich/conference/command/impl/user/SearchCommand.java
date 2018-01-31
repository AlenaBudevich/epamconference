package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ConferenceService;
import by.budevich.conference.service.ReportService;
import by.budevich.conference.service.SectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 30.01.2018.
 */
public class SearchCommand implements BaseCommand {
    public static SearchCommand instance = new SearchCommand();

    private SearchCommand() {
    }

    public static SearchCommand getInstance() {
        return instance;
    }
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        String value = request.getParameter("query");
        String type = request.getParameter("type");
        ArrayList result;
        if (type.equals("report")) {
            result = new ArrayList<Report>();
            result.add(ReportService.getInstance().findReportByName(value));
            System.out.println(result.toString());
            request.setAttribute("result", result);
            return "jsp/search.jsp";
        }
        else if (type.equals("section")) {
            result = SectionService.getInstance().findSectionsByName(value);
            request.setAttribute("result", result);
            return "jsp/search.jsp";
        }
        else if (type.equals("conference")){
            result = new ArrayList<Conference>();
            result.add(ConferenceService.getInstance().findConferenceByName(value));
            request.setAttribute("result", result);
            return "jsp/search.jsp";
        }
        else {
            return "jsp/error.jsp";
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        return null;
    }
}
