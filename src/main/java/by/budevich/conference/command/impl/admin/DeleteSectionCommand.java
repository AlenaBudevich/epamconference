package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.SectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 01.02.2018.
 */
public class DeleteSectionCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(DeleteSectionCommand.class);

    public static DeleteSectionCommand instance = new DeleteSectionCommand();

    private DeleteSectionCommand() {
    }

    public static DeleteSectionCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        String sectionId = request.getParameter(ParameterConst.PARAMETER_SECTION_ID);
        SectionService.getInstance().deleteSection(sectionId);
        return ViewAllConferencesCommand.getInstance().getPage(request, response);
    }
}
