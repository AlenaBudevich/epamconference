package by.budevich.conference.command.impl.user;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 31.01.2018.
 */
public class DeleteReportCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(DeleteReportCommand.class);

    public static DeleteReportCommand instance = new DeleteReportCommand();

    private DeleteReportCommand() {}

    public static DeleteReportCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        String reportId = request.getParameter(ParameterConst.PARAMETER_REPORT_ID);
        ReportService.getInstance().deleteReport(reportId);
        return ViewUserReportsCommand.getInstance().getPage(request, response);
    }
}
