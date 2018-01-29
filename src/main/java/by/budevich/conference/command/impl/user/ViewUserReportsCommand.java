package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 29.01.2018.
 */
public class ViewUserReportsCommand implements BaseCommand {
    public static ViewUserReportsCommand instance = new ViewUserReportsCommand();

    private ViewUserReportsCommand() {
    }

    public static ViewUserReportsCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        if (request.getSession().getAttribute("userId") != null) {
            long id = (Long)request.getSession().getAttribute("userId");
            ArrayList<Report> userReports= ReportService.getInstance().showReportsByAnyId("user", id);
            request.setAttribute("userReports", userReports);
            return "jsp/userreports.jsp";
        }
        else return "jsp/error.jsp";
    }
}
