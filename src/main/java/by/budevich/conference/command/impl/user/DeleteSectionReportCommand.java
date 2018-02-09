package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Report;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ReportService;
import by.budevich.conference.service.SectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 01.02.2018.
 */
public class DeleteSectionReportCommand implements BaseCommand{
    public static DeleteSectionReportCommand instance = new DeleteSectionReportCommand();

    private DeleteSectionReportCommand() {
    }

    public static DeleteSectionReportCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        String role = (String) request.getSession().getAttribute(AttributeConst.ATTR_ROLE);
        long userId = (Long)request.getSession().getAttribute(AttributeConst.ATTR_USER_ID);
        String reportName = request.getParameter(ParameterConst.PARAMETER_REPORT_NAME);
        Report report = ReportService.getInstance().findReportByName(reportName);
        if (report==null) {
            return PageConst.PAGE_ERROR;
        }
        long reportId = report.getReportId();
        int ownReport = ReportService.getInstance().checkUserReport(reportId, userId);
        if (role.equalsIgnoreCase(ParameterConst.PARAMETER_ROLE_ADMIN) || ownReport!=0){
            String sectionName = request.getParameter(ParameterConst.PARAMETER_SECTION_NAME);
            Section section = SectionService.getInstance().findSectionsByName(sectionName);
            if (section==null) {
                return  PageConst.PAGE_ERROR;
            }
            long sectionId = section.getSectionId();
            ReportService.getInstance().deleteReportFrom(ParameterConst.PARAMETER_SECTION, reportId , sectionId);
            return ViewUserReportsCommand.getInstance().getPage(request, response);
        }else {
            return PageConst.PAGE_ERROR;
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        request.setAttribute(AttributeConst.ATTR_DELETE_SECTION_REPORT, true);
        return ViewUserReportsCommand.getInstance().getPage(request, response);
    }
}
