package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.entity.Report;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ReportService;
import by.budevich.conference.service.SectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 01.02.2018.
 */
public class AddSectionReportCommand implements BaseCommand {
    public static AddSectionReportCommand instance = new AddSectionReportCommand();

    private AddSectionReportCommand() {
    }

    public static AddSectionReportCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, SQLException, DAOException {
        String role = (String) request.getSession().getAttribute("role");
        long userId = (Long)request.getSession().getAttribute("userId");
        String reportName = request.getParameter("reportName");
        Report report = ReportService.getInstance().findReportByName(reportName);
        if (report==null) {
            return  "jsp/error.jsp";
        }
        long reportId = report.getReportId();
        int ownReport = ReportService.getInstance().checkUserReport(reportId, userId);
        if (role.equalsIgnoreCase("ADMIN") || ownReport!=0){
            String sectionName = request.getParameter("sectionName");
            Section section = SectionService.getInstance().findSectionsByName(sectionName);
            if (section==null) {
                return  "jsp/error.jsp";
            }
            long sectionId = section.getSectionId();
            ReportService.getInstance().addReportTo("section", sectionId, reportId);
            return ViewUserReportsCommand.getInstance().getPage(request, response);
        }else {
            return "jsp/error.jsp";
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServiceException, DAOException {
        request.setAttribute("addSectionReport", true);
        return ViewUserReportsCommand.getInstance().getPage(request, response);
    }
}
