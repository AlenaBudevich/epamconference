package by.budevich.conference.service;

import by.budevich.conference.dao.BaseUserDAO;
import by.budevich.conference.dao.impl.UserDAO;
import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.util.SHA256Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Asus on 22.01.2018.
 */
public class UserService {
    static final Logger LOGGER = LogManager.getLogger(UserService.class);
    private BaseUserDAO dao;
    private static UserService instance = new UserService();

    private UserService() {
        dao = new UserDAO();
    }

    public static UserService getInstance() {
        if(instance==null){
            instance = new UserService();
        }
        return instance;
    }

    public void addUser(String login, String password, String email) throws DAOException {
        LOGGER.info("The addUser() method is called with the input data:" + login + ", "+password+", "+email);
        User user = new User(login, SHA256Util.encrypt(password), email);
        dao.addUser(user);
    }

    public User findUserByLogin(String login) throws DAOException {
        LOGGER.info("The findUserByLogin() method is called with the input data:" + login);
        return dao.findUserByLogin(login);
    }

    public void updateUserInfo(User user) throws DAOException {
        LOGGER.info("The updateUserInfo() method is called with the input data:" + user.toString());
        dao.updateUserInfo(user);
    }

    public User findUserById(long userId) throws DAOException {
        LOGGER.info("The findUserById() method is called with the input data:" + userId);
        return dao.findUserById(userId);
    }

    public void assignRoleToUser(long userId, String role) throws DAOException {
        LOGGER.info("The assignRoleToUser() method is called with the input data:" + userId+", "+role);
        dao.assignRoleToUser(userId, role);
    }

    public ArrayList<User> showUsers(long userId) throws DAOException {
        LOGGER.info("The showUsers() method is called with the input data:" + userId);
        return dao.showUsers(userId);
    }

    public void deleteUser(String userId) throws DAOException {
        LOGGER.info("The deleteUser() method is called with the input data:" + userId);
        dao.deleteUser(Long.parseLong(userId));
    }
}
