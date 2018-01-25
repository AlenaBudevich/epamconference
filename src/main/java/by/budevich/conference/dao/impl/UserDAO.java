package by.budevich.conference.dao.impl;

import by.budevich.conference.dao.BaseUserDAO;
import by.budevich.conference.entity.User;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Asus on 15.01.2018.
 */
public class UserDAO implements BaseUserDAO {

    private static UserDAO instance = new UserDAO();

    public static UserDAO getInstance(){
        return instance;
    }

    private static final String SQL_ADD_USER =
            "INSERT INTO user (userID, login, password, email, role, phoneNumber," +
                    "avatar, firstName, lastName, surname) VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_FIND_USER_BY_LOGIN = "SELECT userID, login, password, " +
            "email, role, phoneNumber, avatar, firstName, lastName, surname" +
            " FROM user " +
            "WHERE login = ? ";

    private static final String SQL_FIND_USER_BY_ID = "SELECT userID, login, password, " +
            "email, role, phoneNumber, avatar, firstName, lastName, surname" +
            " FROM user" +
            " WHERE userID = ?";


    private static final String SQL_UPDATE_USER_INFO = "UPDATE user SET email = ?, phoneNumber = ?," +
            "avatar = ?, firstName = ?, lastName = ?, surname = ? " +
            "WHERE userID = ?";

    private static final String SQL_ASSIGN_ROLE = "UPDATE user SET role = ? WHERE userID = ?";

    private static final String SQL_VIEW_USER_TABLE = "SELECT userID, login, password, email, " +
            "role, phoneNumber, avatar, firstName, lastName, surname " +
            "FROM user ";

    private static final String SQL_DELETE_USER = " DELETE FROM user WHERE userID = ?";

    public void addUser(User user) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_USER);
            preparedStatement.setLong(1, user.getUserId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setInt(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getAvatar());
            preparedStatement.setString(8, user.getFirstName());
            preparedStatement.setString(9, user.getLastName());
            preparedStatement.setString(10, user.getSurname());
            preparedStatement.executeUpdate();
    }

    public User findUserByLogin (String login) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_LOGIN);
        preparedStatement.setString(1,login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return initUser(resultSet);
        }
        else {
            return null;
        }
    }

    public User findUserById(long userId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_ID);
        preparedStatement.setLong(1,userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return initUser(resultSet);
        }
        else {
            return null;
        }
    }

    public void updateUserInfo(User user) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_INFO);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setInt(2, user.getPhoneNumber());
        preparedStatement.setString(3, user.getAvatar());
        preparedStatement.setString(4, user.getFirstName());
        preparedStatement.setString(5, user.getLastName());
        preparedStatement.setString(6, user.getSurname());
        preparedStatement.setLong(7, user.getUserId());
        preparedStatement.executeUpdate();
    }

    public void assignRoleToUser(long userId, String role) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_ASSIGN_ROLE);
        preparedStatement.setString(1,role);
        preparedStatement.setLong(2,userId);
        preparedStatement.executeUpdate();
    }

    public ArrayList<User> showUsers() throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SQL_VIEW_USER_TABLE);
        ArrayList<User> userList = initUserTable(result);
        return userList;
    }

    private User initUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getLong(1));
        user.setLogin(resultSet.getString(2));
        user.setPassword(resultSet.getString(3));
        user.setEmail(resultSet.getString(4));
        user.setRole(resultSet.getString(5));
        user.setPhoneNumber(resultSet.getInt(6));
        user.setAvatar(resultSet.getString(7));
        user.setFirstName(resultSet.getString(8));
        user.setLastName(resultSet.getString(9));
        user.setSurname(resultSet.getString(10));
        return user;
    }

    private ArrayList<User> initUserTable(ResultSet resultSet) throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        User user;
        while (resultSet.next()) {
            user = initUser(resultSet);
            users.add(user);
        }
        return users;
    }
}
