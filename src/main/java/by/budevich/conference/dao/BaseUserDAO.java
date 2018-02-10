package by.budevich.conference.dao;

import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by Asus on 15.01.2018.
 */
public interface BaseUserDAO {
    void addUser(User user) throws DAOException;
    void deleteUser(long userId) throws DAOException;
    void updateUserInfo(User user) throws DAOException;
    void assignRoleToUser(long userId, String role) throws DAOException;
    User findUserByLogin(String login) throws DAOException;
    User findUserById(long userId) throws DAOException;
    ArrayList<User> showUsers(long userId) throws DAOException;
}
