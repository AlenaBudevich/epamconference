package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 31.01.2018.
 */
public class DeleteReportCommand implements BaseCommand {
    public static DeleteReportCommand instance = new DeleteReportCommand();

    private DeleteReportCommand() {
    }

    public static DeleteReportCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException {
        String reportId = request.getParameter("reportId");
        ReportService.getInstance().deleteReport(reportId);
        return ViewUserReportsCommand.getInstance().getPage(request, response);
    }
}
