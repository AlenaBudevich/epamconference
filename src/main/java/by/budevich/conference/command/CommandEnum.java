package by.budevich.conference.command;

import by.budevich.conference.command.impl.admin.*;
import by.budevich.conference.command.impl.common.RegistrationCommand;
import by.budevich.conference.command.impl.common.ViewAllConferencesCommand;
import by.budevich.conference.command.impl.user.*;

/**
 * Created by Asus on 22.01.2018.
 */
public enum CommandEnum {
    REGISTRATION (RegistrationCommand.getInstance()),
    VIEWALLCONFERENCES (ViewAllConferencesCommand.getInstance()),

    LOGIN(LoginCommand.getInstance()),
    LOGOUT (LogoutCommand.getInstance()),
    VIEWPROFILEINFO (ViewProfileInfoCommand.getInstance()),
    CHANGEPROFILEINFO (ChangeProfileInfoCommand.getInstance()),

    VIEWUSERREPORTS (ViewUserReportsCommand.getInstance()),
    ADDBASICREPORTINFO (AddBasicReportInfoCommand.getInstance()),
    UPDATEREPORTINFO (UpdateReportInfoCommand.getInstance()),
    DELETEREPORT (DeleteReportCommand.getInstance()),

    VIEWCONFERENCESECTIONS (ViewConferenceSectionsCommand.getInstance()),
    VIEWSECTIONREPORTS (ViewSectionReportsCommand.getInstance()),

    VIEWUSERS (ViewUsersCommand.getInstance()),
    ASSIGNUSERROLE (AssignUserRoleCommand.getInstance()),
    ASSIGNREPORTSTATUS (AssignReportStatusCommand.getInstance()),

    VIEWUSERINCOMINGMESSAGES (ViewUserIncomingMessagesCommand.getInstance()),
    VIEWUSEROUTGOINGMESSAGES (ViewUserOutgoingMessagesCommand.getInstance()),
    SENDMESSAGE (SendMessageCommand.getInstance()),
    CHANGEMESSAGE (ChangeMessageCommand.getInstance()),
    DELETEMESSAGE (DeleteMessageCommand.getInstance()),

    ADDCONFERENCE (AddConferenceCommand.getInstance()),
    UPDATECONFERENCEINFO (UpdateConferenceInfoCommand.getInstance()),
    DELETECONFERENCE (DeleteConferenceCommand.getInstance()),

    ADDSECTION (AddSectionCommand.getInstance()),
    UPDATESECTIONINFO (UpdateSectionInfoCommand.getInstance()),
    DELETESECTION (DeleteSectionCommand.getInstance()),

    ADDSECTIONREPORT (AddSectionReportCommand.getInstance()),
    DELETESECTIONREPORT (DeleteSectionReportCommand.getInstance());

    BaseCommand command;
    CommandEnum(BaseCommand instance) {
        this.command = instance;
    }

    public BaseCommand getCurrentCommand(){
        return command;
    }
}
