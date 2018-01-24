package by.budevich.conference.controller;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.exception.DAOException;
import by.budevich.conference.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Asus on 21.01.2018.
 */
@WebServlet(name = "controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    public Controller() {
        super();
    }

    public void init() throws ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        CommandFactory commandFactory = new CommandFactory();
        BaseCommand command = commandFactory.defineCommand(request);
        try {
            String page = command.execute(request, response);
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory commandFactory = new CommandFactory();
        BaseCommand command = commandFactory.defineCommand(request);

        String page = null;
        try {
            page = command.getPage(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher(page).forward(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}
