package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Section;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.SectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

/**
 * Created by Asus on 01.02.2018.
 */
public class UpdateSectionInfoCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(UpdateSectionInfoCommand.class);

    public static UpdateSectionInfoCommand instance = new UpdateSectionInfoCommand();

    private UpdateSectionInfoCommand() {}

    public static UpdateSectionInfoCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The execute() method is called");

        String sectionId = request.getParameter(ParameterConst.PARAMETER_SECTION_ID);
        Section section = SectionService.getInstance().findSectionById(sectionId);
        String sectionName = request.getParameter(ParameterConst.PARAMETER_SECTION_NAME);
        if (SectionService.getInstance().findSectionsByName(sectionName).getSectionName() == null ||
                sectionName.equals(section.getSectionName())) {

            section.setSectionName(sectionName);
            int maxNumberReports = Integer.parseInt(request.getParameter(ParameterConst.PARAMETER_MAX_NUMBER_REPORTS));
            section.setMaxNumberReports(maxNumberReports);
            Timestamp sectionBeginning = Timestamp.valueOf(request.getParameter(ParameterConst.PARAMETER_SECTION_BEGINNING));
            section.setSectionBeginning(sectionBeginning);
            Timestamp sectionEnd = Timestamp.valueOf(request.getParameter(ParameterConst.PARAMETER_SECTION_END));
            section.setSectionEnd(sectionEnd);
            section.setSectionAddress(request.getParameter(ParameterConst.PARAMETER_SECTION_ADDRESS));
            section.setSectionContent(request.getParameter(ParameterConst.PARAMETER_SECTION_CONTENT));
            section.setSectionStatus(request.getParameter(ParameterConst.PARAMETER_SECTION_STATUS));

            SectionService.getInstance().updateSectionInfo(section);
            return ViewAllConferencesCommand.getInstance().getPage(request, response);
        }
        else {
            return PageConst.PAGE_ERROR;
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        String sectionId = request.getParameter(ParameterConst.PARAMETER_SECTION_ID);
        Section section = SectionService.getInstance().findSectionById(sectionId);
        request.setAttribute(AttributeConst.ATTR_SECTION, section);
        return PageConst.PAGE_UPDATE_SECTION_INFO;
    }
}
