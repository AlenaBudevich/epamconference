package by.budevich.conference.service;

import by.budevich.conference.dao.BaseUserDAO;
import by.budevich.conference.dao.impl.UserDAO;
import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;

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

    public void addUser(String login, String password, String email) throws ServiceException, SQLException, DAOException {
        try {
            User user = new User(login, password, email);
            dao.addUser(user);
        } catch (DAOException e) {
            throw new ServiceException("Can't add user to a database ", e);
        }
    }

    public User findUserByLogin(String login) throws ServiceException, SQLException {
        try {
            return dao.findUserByLogin(login);
        } catch (DAOException e) {
            throw new ServiceException("There's no user with such login ", e);
        }
    }

    public User checkUser(User user, String password) throws ServiceException, SQLException {
        User baseUser = findUserByLogin(user.getLogin());
        if (!password.equals(baseUser.getPassword())) {
            throw new ServiceException("Wrong password ");
        }
        return user;
    }

    public void updateUserInfo(String userId, String login, String password, String email,
                               int phoneNumber, String firstName, String lastName, String surname)
            throws ServiceException, SQLException {
        try {
            User user = new User();
            user.setUserId(Long.parseLong(userId));
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setSurname(surname);
            dao.updateUserInfo(user);
        } catch (DAOException e) {
            throw new ServiceException("Can't update user in service method ", e);
        }
    }

    public User findUserById(String userId) throws ServiceException, SQLException {
        try {
            return dao.findUserById(Long.parseLong(userId));
        } catch (DAOException e) {
            throw new ServiceException("Can't find user with such id ", e);
        }
    }

    public void assignRoleToUser(String userId, String role) throws ServiceException, SQLException {
        try {
            dao.assignRoleToUser(Long.parseLong(userId), role);
        } catch (DAOException e) {
            throw new ServiceException("Can't assign new role for user with id ", e);
        }
    }

    public ArrayList<User> showUsers() throws ServiceException, SQLException {
        try {
            return dao.showUsers();
        } catch (DAOException e) {
            throw new ServiceException("Can't show user table ", e);
        }
    }

    public void deleteUser(String userId) throws ServiceException, SQLException {
        try {
            dao.deleteUser(Long.parseLong(userId));
        } catch (DAOException e) {
            throw new ServiceException("Can't delete user in service method ", e);
        }

    }
}
