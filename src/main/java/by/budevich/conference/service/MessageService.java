package by.budevich.conference.service;

import by.budevich.conference.dao.BaseMessageDAO;
import by.budevich.conference.dao.impl.MessageDAO;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by Asus on 25.01.2018.
 */
public class MessageService {
    private BaseMessageDAO dao;
    private static MessageService instance = new MessageService();

    private MessageService() {
        dao = new MessageDAO();
    }

    public static MessageService getInstance() {
        if(instance==null){
            instance = new MessageService();
        }
        return instance;
    }

    public void sendMessage(Message message) throws DAOException {
        dao.sendMessage(message);
    }

    public void deleteMessage(long messageId) throws DAOException {
        dao.deleteMessage(messageId);

    }

    public void updateSendedMessage(Message message) throws DAOException {
        dao.updateSendedMessage(message);
    }

    public Message findMessageById(long messageId) throws DAOException {
        return dao.findMessageById(messageId);
    }

    public ArrayList<Message> showUsersDialog(String sendId, String receiveId) throws DAOException {
        long sendUserId = Long.parseLong(sendId);
        long receiveUserId = Long.parseLong(receiveId);
        return dao.showUsersDialog(sendUserId, receiveUserId);
    }

    public ArrayList<Message> showIncomingMessagesByUserId(long userId) throws DAOException {
        return dao.showIncomingMessagesByUserId(userId);
    }

    public ArrayList<Message> showOutgoingMessagesByUserId(long userId) throws DAOException {
        return dao.showOutgoingMessagesByUserId(userId);
    }
}
