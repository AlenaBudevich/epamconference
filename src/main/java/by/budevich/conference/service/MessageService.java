package by.budevich.conference.service;

import by.budevich.conference.dao.BaseMessageDAO;
import by.budevich.conference.dao.impl.MessageDAO;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 25.01.2018.
 */
public class MessageService {
    private BaseMessageDAO dao;
    private static MessageService instance = new MessageService();

    private MessageService() {
        dao = MessageDAO.getInstance();
    }

    public static MessageService getInstance() {
        return instance;
    }

    public void sendMessage(Message message) throws SQLException, DAOException {
        dao.sendMessage(message);
    }

    public void deleteMessage(long messageId) throws DAOException, SQLException {
        dao.deleteMessage(messageId);

    }

    public void updateSendedMessage(Message message) throws SQLException, DAOException {
        dao.updateSendedMessage(message);
    }

    public Message findMessageById(long messageId) throws SQLException, DAOException {
        return dao.findMessageById(messageId);
    }

    public ArrayList<Message> showUsersDialog(String sendId, String receiveId) throws SQLException, DAOException {
        long sendUserId = Long.parseLong(sendId);
        long receiveUserId = Long.parseLong(receiveId);
        return dao.showUsersDialog(sendUserId, receiveUserId);
    }

    public ArrayList<Message> showIncomingMessagesByUserId(long userId) throws SQLException, DAOException {
        return dao.showIncomingMessagesByUserId(userId);
    }

    public ArrayList<Message> showOutgoingMessagesByUserId(long userId) throws SQLException, DAOException {
        return dao.showOutgoingMessagesByUserId(userId);
    }
}
