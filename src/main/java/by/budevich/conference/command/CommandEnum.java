package by.budevich.conference.command;

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
    UPDATEREPORTINFO (UpdateReportInfoCommand.getInstance()),
    SEARCH (SearchCommand.getInstance());

    BaseCommand command;
    CommandEnum(BaseCommand instance) {
        this.command = instance;
    }

    public BaseCommand getCurrentCommand(){
        return command;
    }
}
