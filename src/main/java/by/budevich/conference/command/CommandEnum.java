package by.budevich.conference.command;

import by.budevich.conference.command.impl.common.*;
/**
 * Created by Asus on 22.01.2018.
 */
public enum CommandEnum {
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
