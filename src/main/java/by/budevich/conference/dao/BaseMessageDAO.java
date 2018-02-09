package by.budevich.conference.dao;

import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;

import java.util.ArrayList;

/**
 * Created by Asus on 25.01.2018.
 */
public interface BaseMessageDAO {
    void sendMessage(Message message) throws DAOException;
    void deleteMessage(long messageId) throws DAOException;
    void updateSendedMessage(Message message) throws DAOException;
    Message findMessageById(long messageId) throws DAOException;
    ArrayList<Message> showUsersDialog(long sendId, long receiveId) throws DAOException;
    ArrayList<Message> showIncomingMessagesByUserId(long userId) throws DAOException;
    ArrayList<Message> showOutgoingMessagesByUserId(long userId) throws DAOException;
}
