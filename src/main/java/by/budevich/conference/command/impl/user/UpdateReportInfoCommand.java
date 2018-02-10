package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.ErrorMessageConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Report;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 30.01.2018.
 */
public class UpdateReportInfoCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(UpdateReportInfoCommand.class);

    public static UpdateReportInfoCommand instance = new UpdateReportInfoCommand();

    private UpdateReportInfoCommand() {}

    public static UpdateReportInfoCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The execute() method is called");

        long reportId = Long.parseLong(request.getParameter(ParameterConst.PARAMETER_REPORT_ID));
        Report report = ReportService.getInstance().findReportById(reportId);
        String reportName = request.getParameter(ParameterConst.PARAMETER_REPORT_NAME);
        if (reportName.equals(report.getReportName()) ||
                ReportService.getInstance().findReportByName(reportName).getReportName()==null) {
            report.setReportName(reportName);
            report.setReportTheses(request.getParameter(ParameterConst.PARAMETER_REPORT_THESES));
            report.setReportContent(request.getParameter(ParameterConst.PARAMETER_REPORT_CONTENT));
            ReportService.getInstance().updateReportInfo(report);
            return ViewUserReportsCommand.getInstance().getPage(request, response);
        } else {
            request.setAttribute(AttributeConst.ATTR_ERROR, ErrorMessageConst.ERROR_ADD_REPORT);
            return PageConst.PAGE_ERROR;
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        String reportId = request.getParameter(ParameterConst.PARAMETER_REPORT_ID);
        Report report = ReportService.getInstance().findReportById(Long.parseLong(reportId));
        request.setAttribute(AttributeConst.ATTR_REPORT, report);
        return ViewUserReportsCommand.getInstance().getPage(request, response);
    }
}
