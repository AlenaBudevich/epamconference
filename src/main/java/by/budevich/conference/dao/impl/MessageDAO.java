package by.budevich.conference.dao.impl;

import by.budevich.conference.dao.BaseMessageDAO;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 25.01.2018.
 */
public class MessageDAO implements BaseMessageDAO {
    static final Logger LOGGER = LogManager.getLogger(MessageDAO.class);


    private static final String SQL_ADD_MESSAGE =
            "INSERT INTO message (messageID, messageText, messageContent, sendID, receiveID)" +
                    " VALUES (?,?,?,?,?)";

    private static final String SQL_DELETE_MESSAGE = " DELETE FROM message WHERE messageID = ?";

    private static final String SQL_UPDATE_SENDED_MESSAGE = "UPDATE message SET messageText = ?," +
            " messageContent = ? " +
            "WHERE messageID = ?";

    private static final String SQL_FIND_MESSAGE_BY_ID = "SELECT messageID, messageTime, messageText, " +
            "messageContent, sendID, receiveID" +
            " FROM message" +
            " WHERE messageID = ?";

    private static final String SQL_SHOW_INCOMING_MESSAGES_BY_USER_ID = "SELECT messageID, messageTime, messageText, " +
            "messageContent, sendID, receiveID" +
            " FROM message" +
            " WHERE receiveID = ?";

    private static final String SQL_SHOW_OUTGOING_MESSAGES_BY_USER_ID = "SELECT messageID, messageTime, messageText, " +
            "messageContent, sendID, receiveID" +
            " FROM message" +
            " WHERE sendID = ?";

    private static final String SQL_SHOW_USERS_DIALOG = "SELECT messageID, messageTime, messageText, " +
            "messageContent, sendID, receiveID" +
            " FROM message" +
            " WHERE sendID IN (?,?) AND receiveID IN (?,?)";

    private Message initMessage(ResultSet resultSet) throws SQLException {
        LOGGER.info("The initMessage() method is called");

        Message message = new Message();
        if (resultSet.next()) {
            message.setMessageId(resultSet.getLong(1));
            message.setMessageTime(resultSet.getTimestamp(2));
            message.setMessageText(resultSet.getString(3));
            message.setMessageContent(resultSet.getString(4));
            message.setSendId(resultSet.getLong(5));
            message.setReceiveId(resultSet.getLong(6));
        }
        return message;
    }

    private ArrayList<Message> initMessageTable(ResultSet resultSet) throws SQLException {
        LOGGER.info("The initMessageTable() method is called");

        ArrayList<Message> messages = new ArrayList<Message>();
        while (resultSet.next()) {
            Message message = new Message();
            message.setMessageId(resultSet.getLong(1));
            message.setMessageTime(resultSet.getTimestamp(2));
            message.setMessageText(resultSet.getString(3));
            message.setMessageContent(resultSet.getString(4));
            message.setSendId(resultSet.getLong(5));
            message.setReceiveId(resultSet.getLong(6));
            messages.add(message);
        }
        return messages;
    }

    public void sendMessage(Message message) throws DAOException {
        LOGGER.info("The sendMessage() method is called with the input data:" + message.toString());

        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_MESSAGE);
            preparedStatement.setLong(1, message.getMessageId());
            preparedStatement.setString(2, message.getMessageText());
            preparedStatement.setString(3, message.getMessageContent());
            preparedStatement.setLong(4, message.getSendId());
            preparedStatement.setLong(5, message.getReceiveId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while sending message", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
    }

    public void deleteMessage(long messageId) throws DAOException {
        LOGGER.info("The deleteMessage() method is called with the input data:" + messageId);

        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_MESSAGE);
            preparedStatement.setLong(1, messageId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while deleting message from a database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
    }

    public void updateSendedMessage(Message message) throws DAOException {
        LOGGER.info("The updateSendedMessage() method is called with the input data:" + message.toString());

        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_SENDED_MESSAGE);
            preparedStatement.setString(1, message.getMessageText());
            preparedStatement.setString(2, message.getMessageContent());
            preparedStatement.setLong(3, message.getMessageId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException occurred while updating message in a database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
    }

    public Message findMessageById(long messageId) throws DAOException {
        LOGGER.info("The findMessageById() method is called with the input data:" + messageId);

        Connection connection = ConnectionPool.getInstance().getConnection();
        Message message = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_MESSAGE_BY_ID);
            preparedStatement.setLong(1, messageId);
            ResultSet resultSet = preparedStatement.executeQuery();
            message = initMessage(resultSet);
        } catch (SQLException e) {
            throw new DAOException("Cant' find message with such id ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return message;
    }

    public ArrayList<Message> showUsersDialog(long sendId, long receiveId) throws DAOException {
        LOGGER.info("The showUsersDialog() method is called with the input data:" + sendId+", "+receiveId);

        Connection connection = ConnectionPool.getInstance().getConnection();
        ArrayList<Message> messages = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SHOW_USERS_DIALOG);
            preparedStatement.setLong(1, sendId);
            preparedStatement.setLong(2, receiveId);
            preparedStatement.setLong(3, sendId);
            preparedStatement.setLong(4, receiveId);
            ResultSet resultSet = preparedStatement.executeQuery();
            messages = initMessageTable(resultSet);
        } catch (SQLException e) {
            throw new DAOException("Cant' find such dialog ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return messages;
    }

    public ArrayList<Message> showIncomingMessagesByUserId(long userId) throws DAOException {
        LOGGER.info("The showIncomingMessagesByUserId() method is called with the input data:" + userId);

        Connection connection = ConnectionPool.getInstance().getConnection();
        ArrayList<Message> messages = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SHOW_INCOMING_MESSAGES_BY_USER_ID);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            messages = initMessageTable(resultSet);
        } catch (SQLException e) {
            throw new DAOException("Cant' find such messages ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return messages;

    }

    public ArrayList<Message> showOutgoingMessagesByUserId(long userId) throws DAOException {
        LOGGER.info("The showOutgoingMessagesByUserId() method is called with the input data:" + userId);

        Connection connection = ConnectionPool.getInstance().getConnection();
        ArrayList<Message> messages = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SHOW_OUTGOING_MESSAGES_BY_USER_ID);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            messages = initMessageTable(resultSet);
        } catch (SQLException e) {
            throw new DAOException("Cant' find such messages ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().returnConnection(connection);
            }
        }
        return messages;
    }
}
