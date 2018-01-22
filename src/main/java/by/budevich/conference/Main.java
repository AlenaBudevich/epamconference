package by.budevich.conference;

import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;
import by.budevich.conference.service.UserService;

import java.sql.SQLException;

/**
 * Created by Asus on 21.12.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException, DAOException, ServiceException {
        System.out.println("Hi");
        User user = UserService.getInstance().findUserById("3");
        System.out.println(user);
    }

}
