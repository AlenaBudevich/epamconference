package by.budevich.conference.command;

import by.budevich.conference.exception.DAOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Asus on 22.01.2018.
 */
public interface BaseCommand {
    String execute(HttpServletRequest request, HttpServletResponse response) throws DAOException;
    String getPage(HttpServletRequest request, HttpServletResponse response) throws DAOException;
}
