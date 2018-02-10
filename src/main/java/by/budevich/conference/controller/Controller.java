package by.budevich.conference.controller;

import by.budevich.conference.command.BaseCommand;
import by.budevich.conference.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Asus on 21.01.2018.
 */
@WebServlet(name = "controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    static final Logger LOGGER = LogManager.getLogger(Controller.class);
    public Controller() {
        super();
    }

    public void init() throws ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The doPost() method is called");

        CommandFactory commandFactory = new CommandFactory();
        BaseCommand command = commandFactory.defineCommand(request);
        try {
            String page = command.execute(request, response);
            request.getRequestDispatcher(page).forward(request, response);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("The doGet() method is called");

        CommandFactory commandFactory = new CommandFactory();
        BaseCommand command = commandFactory.defineCommand(request);
        String page = null;
        try {
            page = command.getPage(request, response);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher(page).forward(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}
