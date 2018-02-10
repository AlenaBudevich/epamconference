package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.user.ViewSectionReportsCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 01.02.2018.
 */
public class AssignReportStatusCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(AssignReportStatusCommand.class);

    public static AssignReportStatusCommand instance = new AssignReportStatusCommand();

    private AssignReportStatusCommand() {}

    public static AssignReportStatusCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The execute() method is called");

        long reportId = Long.parseLong(request.getParameter(ParameterConst.PARAMETER_REPORT_ID));
        String status = request.getParameter(ParameterConst.PARAMETER_STATUS);
        ReportService.getInstance().assignStatusToReport(reportId, status);
        System.out.println(request.getParameter(ParameterConst.PARAMETER_SECTION_ID));
        return ViewSectionReportsCommand.getInstance().getPage(request, response);
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        long reportId = Long.parseLong(request.getParameter(ParameterConst.PARAMETER_CHANGE_ID));
        request.setAttribute(AttributeConst.ATTR_CHANGE_ID, reportId);
        return ViewSectionReportsCommand.getInstance().getPage(request, response);
    }
}
