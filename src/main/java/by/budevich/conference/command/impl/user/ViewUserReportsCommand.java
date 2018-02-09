package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    public String execute(HttpServletRequest request, HttpServletResponse response){
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        if (request.getSession().getAttribute(AttributeConst.ATTR_USER_ID) != null) {
            long id = (Long)request.getSession().getAttribute(AttributeConst.ATTR_USER_ID);
            ArrayList<Report> userReports= ReportService.getInstance().showReportsByAnyId(ParameterConst.PARAMETER_USER, id);
            request.setAttribute(AttributeConst.ATTR_USER_REPORTS, userReports);
            return PageConst.PAGE_USER_REPORTS;
        }
        else return PageConst.PAGE_ERROR;
    }
}
