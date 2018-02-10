package by.budevich.conference.command.impl.admin;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.constant.AttributeConst;
import by.budevich.conference.constant.PageConst;
import by.budevich.conference.constant.ParameterConst;
import by.budevich.conference.entity.Conference;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.service.ConferenceService;
import by.budevich.conference.service.SectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 01.02.2018.
 */
public class AddSectionCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(AddSectionCommand.class);

    private static AddSectionCommand instance = new AddSectionCommand();

    private AddSectionCommand() {}

    public static AddSectionCommand getInstance() {
        return instance;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The execute() method is called");

        String conferenceName = request.getParameter(ParameterConst.PARAMETER_CONFERENCE_NAME);
        if (ConferenceService.getInstance().findConferenceByName(conferenceName).getConferenceName() != null) {
            Conference conference = ConferenceService.getInstance().findConferenceByName(conferenceName);
            long conferenceId = conference.getConferenceId();
            String sectionName = request.getParameter(ParameterConst.PARAMETER_SECTION_NAME);

            if (SectionService.getInstance().findSectionsByName(sectionName).getSectionName() == null) {

                SectionService.getInstance().addBasicSectionInfo(conferenceId, sectionName);
                request.setAttribute(AttributeConst.ATTR_CONFERENCE, conference);
                return ViewAllConferencesCommand.getInstance().getPage(request, response);
            } else {
                return PageConst.PAGE_ERROR;
            }
        } else {
            return PageConst.PAGE_ERROR;
        }
    }

    public String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        LOGGER.info("The getPage() method is called");

        return PageConst.PAGE_ADD_SECTION;
    }
}
