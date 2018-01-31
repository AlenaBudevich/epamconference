package by.budevich.conference.dao.impl;

import by.budevich.conference.dao.BaseMessageDAO;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 25.01.2018.
 */
public class MessageDAO implements BaseMessageDAO {
    private static MessageDAO instance = new MessageDAO();

    public static MessageDAO getInstance(){
        return instance;
    }

    private static final String SQL_ADD_MESSAGE =
            "INSERT INTO message (messageID, messageText, messageContent, sendID, receiveID)" +
                    " VALUES (?,?,?,?,?)";

    private static final String SQL_DELETE_MESSAGE = " DELETE FROM message WHERE messageID = ?";

    private static final String SQL_UPDATE_SENDED_MESSAGE = "UPDATE message SET messageText = ?,"+
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
        Message message = new Message();
        message.setMessageId(resultSet.getLong(1));
        message.setMessageTime(resultSet.getTimestamp(2));
        message.setMessageText(resultSet.getString(3));
        message.setMessageContent(resultSet.getString(4));
        message.setSendId(resultSet.getLong(5));
        message.setReceiveId(resultSet.getLong(6));
        return message;
    }

    private ArrayList<Message> initMessageTable(ResultSet resultSet) throws SQLException {
        ArrayList<Message> messages = new ArrayList<Message>();
        Message message;
        while (resultSet.next()) {
            message = initMessage(resultSet);
            messages.add(message);
        }
        return messages;
    }

    public void sendMessage(Message message) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_MESSAGE);
        preparedStatement.setLong(1, message.getMessageId());
        preparedStatement.setString(2, message.getMessageText());
        preparedStatement.setString(3, message.getMessageContent());
        preparedStatement.setLong(4, message.getSendId());
        preparedStatement.setLong(5, message.getReceiveId());
        preparedStatement.executeUpdate();
    }

    public void deleteMessage(long messageId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_MESSAGE);
        preparedStatement.setLong(1, messageId);
        preparedStatement.executeUpdate();
    }

    public void updateSendedMessage(Message message) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_SENDED_MESSAGE);
        preparedStatement.setString(1, message.getMessageText());
        preparedStatement.setString(2, message.getMessageContent());
        preparedStatement.setLong(3, message.getMessageId());
        preparedStatement.executeUpdate();
    }

    public Message findMessageById(long messageId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_MESSAGE_BY_ID);
        preparedStatement.setLong(1,messageId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return initMessage(resultSet);
        }
        else {
            return null;
        }
    }

    public ArrayList<Message> showUsersDialog(long sendId, long receiveId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SHOW_USERS_DIALOG);
        preparedStatement.setLong(1, sendId);
        preparedStatement.setLong(2, receiveId);
        preparedStatement.setLong(3, sendId);
        preparedStatement.setLong(4, receiveId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return initMessageTable(resultSet);
    }

    public ArrayList<Message> showIncomingMessagesByUserId(long userId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SHOW_INCOMING_MESSAGES_BY_USER_ID);
        preparedStatement.setLong(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return initMessageTable(resultSet);
    }

    public ArrayList<Message> showOutgoingMessagesByUserId(long userId) throws DAOException, SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SHOW_OUTGOING_MESSAGES_BY_USER_ID);
        preparedStatement.setLong(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return initMessageTable(resultSet);
    }
}
