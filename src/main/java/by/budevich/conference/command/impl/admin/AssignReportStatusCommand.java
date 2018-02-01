package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.user.ViewSectionReportsCommand;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 01.02.2018.
 */
public class AssignReportStatusCommand implements BaseCommand {
    public static AssignReportStatusCommand instance = new AssignReportStatusCommand();

    private AssignReportStatusCommand() {
    }

    public static AssignReportStatusCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        long reportId = Long.parseLong(request.getParameter("reportId"));
        String status = request.getParameter("status");
        ReportService.getInstance().assignStatusToReport(reportId, status);
        System.out.println(request.getParameter("sectionId"));
        return ViewSectionReportsCommand.getInstance().getPage(request, response);
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        long reportId = Long.parseLong(request.getParameter("changeId"));
        request.setAttribute("changeId", reportId);
        return ViewSectionReportsCommand.getInstance().getPage(request, response);
    }
}
