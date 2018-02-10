package by.budevich.conference.service;

import by.budevich.conference.dao.BaseMessageDAO;
import by.budevich.conference.dao.impl.MessageDAO;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Asus on 25.01.2018.
 */
public class MessageService {
    static final Logger LOGGER = LogManager.getLogger(MessageService.class);

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
        LOGGER.info("The sendMessage() method is called with the input data:" + message.toString());
        dao.sendMessage(message);
    }

    public void deleteMessage(long messageId) throws DAOException {
        LOGGER.info("The deleteMessage() method is called with the input data:" + messageId);
        dao.deleteMessage(messageId);

    }

    public void updateSendedMessage(Message message) throws DAOException {
        LOGGER.info("The updateSendedMessage() method is called with the input data:" + message.toString());
        dao.updateSendedMessage(message);
    }

    public Message findMessageById(long messageId) throws DAOException {
        LOGGER.info("The findMessageById() method is called with the input data:" + messageId);
        return dao.findMessageById(messageId);
    }

    public ArrayList<Message> showUsersDialog(String sendId, String receiveId) throws DAOException {
        LOGGER.info("The showUsersDialog() method is called with the input data:" + sendId+", "+receiveId);
        long sendUserId = Long.parseLong(sendId);
        long receiveUserId = Long.parseLong(receiveId);
        return dao.showUsersDialog(sendUserId, receiveUserId);
    }

    public ArrayList<Message> showIncomingMessagesByUserId(long userId) throws DAOException {
        LOGGER.info("The showIncomingMessagesByUserId() method is called with the input data:" + userId);
        return dao.showIncomingMessagesByUserId(userId);
    }

    public ArrayList<Message> showOutgoingMessagesByUserId(long userId) throws DAOException {
        LOGGER.info("The showOutgoingMessagesByUserId() method is called with the input data:" + userId);
        return dao.showOutgoingMessagesByUserId(userId);
    }
}
