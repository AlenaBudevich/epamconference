package by.budevich.conference.service;

import by.budevich.conference.dao.BaseMessageDAO;
import by.budevich.conference.dao.impl.MessageDAO;
import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;

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

    public void sendMessage(Message message) throws ServiceException, SQLException, DAOException {
        try {
            dao.sendMessage(message);
        } catch (DAOException e) {
            throw new ServiceException("Can't send message ", e);
        }
    }

    public void deleteMessage(long messageId) throws ServiceException, SQLException {
        try {
            dao.deleteMessage(messageId);
        } catch (DAOException e) {
            throw new ServiceException("Can't delete such message ", e);
        }
    }

    public void updateSendedMessage(Message message) throws ServiceException, SQLException, DAOException {
        try {
            dao.updateSendedMessage(message);
        } catch (DAOException e) {
            throw new ServiceException("Can't update message in service method ", e);
        }
    }

    public Message findMessageById(long messageId) throws ServiceException, SQLException {
        try {
            return dao.findMessageById(messageId);
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

    public ArrayList<Message> showIncomingMessagesByUserId(long userId) throws ServiceException, SQLException {
        try {
            return dao.showIncomingMessagesByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException("Can't find message(s) with such userId ", e);
        }
    }

    public ArrayList<Message> showOutgoingMessagesByUserId(long userId) throws ServiceException, SQLException {
        try {
            return dao.showOutgoingMessagesByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException("Can't find message(s) with such userId ", e);
        }
    }
}
