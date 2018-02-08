package by.budevich.conference.service;

import by.budevich.conference.dao.BaseUserDAO;
import by.budevich.conference.dao.impl.UserDAO;
import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.util.SHA256Util;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 22.01.2018.
 */
public class UserService {
    private BaseUserDAO dao;
    private static UserService instance = new UserService();

    private UserService() {
        dao = UserDAO.getInstance();
    }

    public static UserService getInstance() {
        return instance;
    }

    public void addUser(String login, String password, String email) throws SQLException, DAOException {
        User user = new User(login, SHA256Util.encrypt(password), email);
        dao.addUser(user);
    }

    public User findUserByLogin(String login) throws SQLException, DAOException {
        return dao.findUserByLogin(login);
    }

    public void updateUserInfo(User user) throws SQLException, DAOException {
        dao.updateUserInfo(user);
    }

    public User findUserById(long userId) throws SQLException, DAOException {
        return dao.findUserById(userId);
    }

    public void assignRoleToUser(long userId, String role) throws SQLException, DAOException {
        dao.assignRoleToUser(userId, role);
    }

    public ArrayList<User> showUsers() throws SQLException, DAOException {
        return dao.showUsers();
    }

    public void deleteUser(String userId) throws SQLException, DAOException {
        dao.deleteUser(Long.parseLong(userId));
    }
}
