package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Report;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ReportService;
import by.budevich.conference.service.SectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 31.01.2018.
 */
public class ViewSectionReportsCommand implements BaseCommand {
    public static ViewSectionReportsCommand instance = new ViewSectionReportsCommand();

    private ViewSectionReportsCommand() {
    }

    public static ViewSectionReportsCommand getInstance() {
        return instance;
    }
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, SQLException, DAOException {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServiceException, DAOException {
        String sectionId = request.getParameter(ParameterConst.PARAMETER_SECTION_ID);
        Section section = SectionService.getInstance().findSectionById(sectionId);
        ArrayList<Report> sectionReports = ReportService.getInstance().
                showReportsByAnyId(ParameterConst.PARAMETER_SECTION, Long.parseLong(sectionId));
        request.setAttribute(AttributeConst.ATTR_SECTION, section);
        request.setAttribute(AttributeConst.ATTR_REPORTS, sectionReports);
        return PageConst.PAGE_SECTION;
    }
}
