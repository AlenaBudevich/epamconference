package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.user.ViewSectionReportsCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        long reportId = Long.parseLong(request.getParameter(ParameterConst.PARAMETER_REPORT_ID));
        String status = request.getParameter(ParameterConst.PARAMETER_STATUS);
        ReportService.getInstance().assignStatusToReport(reportId, status);
        System.out.println(request.getParameter(ParameterConst.PARAMETER_SECTION_ID));
        return ViewSectionReportsCommand.getInstance().getPage(request, response);
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        long reportId = Long.parseLong(request.getParameter(ParameterConst.PARAMETER_CHANGE_ID));
        request.setAttribute(AttributeConst.ATTR_CHANGE_ID, reportId);
        return ViewSectionReportsCommand.getInstance().getPage(request, response);
    }
}
