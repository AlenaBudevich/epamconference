package by.budevich.conference.command;

import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Asus on 22.01.2018.
 */
public interface BaseCommand {
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, DAOException;
    String getPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServiceException, DAOException;
}
