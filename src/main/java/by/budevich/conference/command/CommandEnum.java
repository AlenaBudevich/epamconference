package by.budevich.conference.command;

import by.budevich.conference.command.impl.common.*;
import by.budevich.conference.command.impl.user.ChangeProfileInfoCommand;
import by.budevich.conference.command.impl.user.ViewProfileInfoCommand;

/**
 * Created by Asus on 22.01.2018.
 */
public enum CommandEnum {
    LOGIN(LoginCommand.getInstance()),
    REGISTRATION (RegistrationCommand.getInstance()),
    VIEWALLCONFERENCES (ViewAllConferencesCommand.getInstance()),

    VIEWPROFILEINFO (ViewProfileInfoCommand.getInstance()),
    CHANGEPROFILEINFO (ChangeProfileInfoCommand.getInstance());

    BaseCommand command;
    CommandEnum(BaseCommand instance) {
        this.command = instance;
    }

    public BaseCommand getCurrentCommand(){
        return command;
    }
}
