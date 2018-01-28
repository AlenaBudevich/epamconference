package by.budevich.conference.dao;

import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 15.01.2018.
 */
public interface BaseUserDAO {
    void addUser(User user) throws DAOException, SQLException;
    void deleteUser(long userId) throws DAOException, SQLException;
    void updateUserInfo(User user) throws DAOException, SQLException;
    void assignRoleToUser(long userId, String role) throws DAOException, SQLException;
    User findUserByLogin(String login) throws DAOException, SQLException;
    User findUserById(long userId) throws DAOException, SQLException;
    ArrayList<User> showUsers() throws DAOException, SQLException;
}
