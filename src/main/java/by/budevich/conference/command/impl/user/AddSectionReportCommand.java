package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.ErrorMessageConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Report;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ReportService;
import by.budevich.conference.service.SectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 01.02.2018.
 */
public class AddSectionReportCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(AddSectionReportCommand.class);

    public static AddSectionReportCommand instance = new AddSectionReportCommand();

    private AddSectionReportCommand() {}

    public static AddSectionReportCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The execute() method is called");

        String role = (String) request.getSession().getAttribute(AttributeConst.ATTR_ROLE);
        long userId = (Long)request.getSession().getAttribute(AttributeConst.ATTR_USER_ID);
        String reportName = request.getParameter(ParameterConst.PARAMETER_REPORT_NAME);
        Report report = ReportService.getInstance().findReportByName(reportName);
        if (report.getReportName()==null) {
            request.setAttribute(AttributeConst.ATTR_ERROR, ErrorMessageConst.ERROR_REPORT);
            return PageConst.PAGE_ERROR;
        }
        long reportId = report.getReportId();
        int ownReport = ReportService.getInstance().checkUserReport(reportId, userId);
        if (role.equalsIgnoreCase(ParameterConst.PARAMETER_ROLE_ADMIN) || ownReport!=0){
            String sectionName = request.getParameter(ParameterConst.PARAMETER_SECTION_NAME);
            Section section = SectionService.getInstance().findSectionsByName(sectionName);
            if (section.getSectionName()==null) {
                request.setAttribute(AttributeConst.ATTR_ERROR, ErrorMessageConst.ERROR_SECTION);
                return  PageConst.PAGE_ERROR;
            }
            long sectionId = section.getSectionId();
            ReportService.getInstance().addReportTo(ParameterConst.PARAMETER_SECTION, sectionId, reportId);
            return ViewUserReportsCommand.getInstance().getPage(request, response);
        }else {
            request.setAttribute(AttributeConst.ATTR_ERROR, ErrorMessageConst.ERROR_ADD_SECTION_REPORT);
            return PageConst.PAGE_ERROR;
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        request.setAttribute(AttributeConst.ATTR_ADD_SECTION_REPORT, true);
        return ViewUserReportsCommand.getInstance().getPage(request, response);
    }
}
