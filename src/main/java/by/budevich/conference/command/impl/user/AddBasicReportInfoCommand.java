package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 31.01.2018.
 */
public class AddBasicReportInfoCommand implements BaseCommand {
    public static AddBasicReportInfoCommand instance = new AddBasicReportInfoCommand();

    private AddBasicReportInfoCommand() {
    }

    public static AddBasicReportInfoCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        String reportName = request.getParameter("reportName");
        if (ReportService.getInstance().findReportByName(reportName)== null){
            String reportTheses = request.getParameter("reportTheses");
            ReportService.getInstance().addBasicReportInfo(reportName, reportTheses);

            long id = (Long) request.getSession().getAttribute("userId");
            Report report = ReportService.getInstance().findReportByName(reportName);
            ReportService.getInstance().addReportTo("user", id, report.getReportId());
            return ViewUserReportsCommand.getInstance().getPage(request, response);

        }
        else {
            return "jsp/error.jsp";
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        request.setAttribute("addReport", true);
        return ViewUserReportsCommand.getInstance().getPage(request, response);
    }
}
