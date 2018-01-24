package by.budevich.conference.command;

import by.budevich.conference.command.common.LoginCommand;
import by.budevich.conference.command.common.RegistrationCommand;

/**
 * Created by Asus on 22.01.2018.
 */
public enum  CommandEnum {
    LOGIN(LoginCommand.getInstance()),
    REGISTRATION (RegistrationCommand.getInstance());

    BaseCommand command;
    CommandEnum(BaseCommand instance) {
        this.command = instance;
    }

    public BaseCommand getCurrentCommand(){
        return command;
    }
}
