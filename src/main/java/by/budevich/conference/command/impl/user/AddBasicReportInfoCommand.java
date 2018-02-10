package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
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
 * Created by Asus on 31.01.2018.
 */
public class AddBasicReportInfoCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(AddBasicReportInfoCommand.class);

    public static AddBasicReportInfoCommand instance = new AddBasicReportInfoCommand();

    private AddBasicReportInfoCommand() {
    }

    public static AddBasicReportInfoCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The execute() method is called");

        String reportName = request.getParameter(ParameterConst.PARAMETER_REPORT_NAME);
        if (ReportService.getInstance().findReportByName(reportName).getReportName()== null){
            String reportTheses = request.getParameter(ParameterConst.PARAMETER_REPORT_THESES);
            ReportService.getInstance().addBasicReportInfo(reportName, reportTheses);

            long id = (Long) request.getSession().getAttribute(AttributeConst.ATTR_USER_ID);
            Report report = ReportService.getInstance().findReportByName(reportName);
            ReportService.getInstance().addReportTo(ParameterConst.PARAMETER_USER, id, report.getReportId());
            return ViewUserReportsCommand.getInstance().getPage(request, response);

        }
        else {
            return PageConst.PAGE_ERROR;
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        request.setAttribute(AttributeConst.ATTR_ADD_REPORT, true);
        return ViewUserReportsCommand.getInstance().getPage(request, response);
    }
}
