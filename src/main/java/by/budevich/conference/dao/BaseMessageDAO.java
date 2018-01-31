package by.budevich.conference.dao;

import by.budevich.conference.entity.Message;
import by.budevich.conference.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Asus on 25.01.2018.
 */
public interface BaseMessageDAO {
    void sendMessage(Message message) throws DAOException, SQLException;
    void deleteMessage(long messageId) throws DAOException, SQLException;
    void updateSendedMessage(Message message) throws DAOException, SQLException;
    Message findMessageById(long messageId) throws DAOException, SQLException;
    ArrayList<Message> showUsersDialog(long sendId, long receiveId) throws DAOException, SQLException;
    ArrayList<Message> showIncomingMessagesByUserId(long userId) throws DAOException, SQLException;
    ArrayList<Message> showOutgoingMessagesByUserId(long userId) throws DAOException, SQLException;
}
