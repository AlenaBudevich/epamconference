package by.budevich.conference.service;

import by.budevich.conference.dao.BaseMessageDAO;
import by.budevich.conference.dao.impl.MessageDAO;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;

import java.sql.SQLException;
import java.sql.Timestamp;
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

    public void sendMessage(String messageID, Timestamp messageTime, String messageText, String messageContent,
                            String sendID, String receiveID) throws ServiceException, SQLException, DAOException {
        try {
            Message message = new Message();
            message.setMessageId(Long.parseLong(messageID));
            message.setMessageTime(messageTime);
            message.setMessageText(messageText);
            message.setMessageContent(messageContent);
            message.setSendId(Long.parseLong(sendID));
            message.setReceiveId(Long.parseLong(receiveID));
            dao.sendMessage(message);
        } catch (DAOException e) {
            throw new ServiceException("Can't send message ", e);
        }
    }

    public void deleteMessage(Message message) throws ServiceException, SQLException {
        try {
            long messageId = message.getMessageId();
            dao.deleteMessage(messageId);
        } catch (DAOException e) {
            throw new ServiceException("Can't delete such message ", e);
        }
    }

    public void updateSendedMessage(String messageID, Timestamp messageTime, String messageText, String messageContent,
                                    String sendID, String receiveID) throws ServiceException, SQLException, DAOException {
        try {
            Message message = new Message();
            message.setMessageId(Long.parseLong(messageID));
            message.setMessageTime(messageTime);
            message.setMessageText(messageText);
            message.setMessageContent(messageContent);
            message.setSendId(Long.parseLong(sendID));
            message.setReceiveId(Long.parseLong(receiveID));
            dao.updateSendedMessage(message);
        } catch (DAOException e) {
            throw new ServiceException("Can't update message in service method ", e);
        }
    }

    public Message findMessageById(String messageId) throws ServiceException, SQLException {
        try {
            return dao.findMessageById(Long.parseLong(messageId));
        } catch (DAOException e) {
            throw new ServiceException("Can't find message with such id ", e);
        }
    }

    public ArrayList<Message> showUsersDialog(String sendId, String receiveId) throws ServiceException, SQLException {
        try {
            long sendUserId = Long.parseLong(sendId);
            long receiveUserId = Long.parseLong(receiveId);
            return dao.showUsersDialog(sendUserId, receiveUserId);
        } catch (DAOException e) {
            throw new ServiceException("Can't find such dialog ", e);
        }
    }

    public ArrayList<Message> showMessagesByUserId(String userId) throws ServiceException, SQLException {
        try {
            return dao.showMessagesByUserId(Long.parseLong(userId));
        } catch (DAOException e) {
            throw new ServiceException("Can't find message(s) with such userId ", e);
        }
    }
}
