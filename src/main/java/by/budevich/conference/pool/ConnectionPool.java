package by.budevich.conference.pool;

import by.budevich.conference.constant.DBConst;
import by.budevich.conference.exception.ConnectionPoolException;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Asus on 15.01.2018.
 */
public class ConnectionPool {
    private static Lock lock = new ReentrantLock();

    private BlockingQueue<Connection> availableConnectionsQueue;
    private BlockingQueue<Connection> usedConnectionsQueue;

    private String url;
    private String user;
    private String password;
    private String locationOfDriver;
    private int connectionAmount;

    private static ConnectionPool instance;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);

    public static ConnectionPool getInstance(){

        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                    instanceCreated.getAndSet(true);
                }
            }
            finally {
                lock.unlock();
            }

        }
        return instance;
    }

    private ConnectionPool(){
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(DBConst.BUNDLE);
            this.url = bundle.getString(DBConst.URL);
            this.user = bundle.getString(DBConst.USER);
            this.password = bundle.getString(DBConst.PASSWORD);
            this.locationOfDriver = bundle.getString(DBConst.DRIVER);
            this.connectionAmount = Integer.parseInt(bundle.getString(DBConst.CONNECTION_AMOUNT));
            this.availableConnectionsQueue = new ArrayBlockingQueue<Connection>(connectionAmount);
            this.usedConnectionsQueue = new ArrayBlockingQueue<Connection>(connectionAmount);
            initPool();
        } catch(NumberFormatException e){
            this.connectionAmount = DBConst.DEFAULT_AMOUNT;
        } catch (MissingResourceException e){
            //logger.fatal("JDBC: Can't find resource bundle ", e);
            throw new RuntimeException("JDBC: Can't find resource bundle", e);
        } catch (ConnectionPoolException e) {
            throw new RuntimeException("JDBC: Incorrect initialization of the class");
        }
    }

    @PostConstruct
    private void initPool() throws ConnectionPoolException {
        //logger.info("Creating pool pool");
        try {
            Class.forName(locationOfDriver);
            Locale.setDefault(Locale.ENGLISH);
            for(int i=0; i < connectionAmount; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                availableConnectionsQueue.put(connection);
                //logger.info("Connection "+ i +" is created and put into the queue.");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC: Can't find driver class ", e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = availableConnectionsQueue.take();
            usedConnectionsQueue.put(connection);
        } catch (InterruptedException e) {
            //logger.error("Interrupted exception occurred while taking connection from the pool ", e);
        }
        //logger.info("Connection is taken.");
        return connection;
    }

    public void returnConnection(Connection connection) {
        try {
            //logger.info("Trying to return connection to the connection pool...");
            availableConnectionsQueue.put(connection);
            usedConnectionsQueue.remove(connection);
            //logger.info("Connection is successfully returned.");
        } catch (InterruptedException e) {
            //logger.error("InterruptedException occurred while returning a connection");
        }

    }

    public void destroyPool() throws ConnectionPoolException {
        //logger.info("Destroying connection pool.");
        try {
            for (int i = 0; i < connectionAmount; i++) {
                Connection connection = ConnectionPool.getInstance().getConnection();
                connection.close();
                //logger.info("Connection "+ i +" is destroyed.");
            }
        } catch (SQLException e) {
            //logger.warn("Can't destroy connection pool.");
            throw new ConnectionPoolException("Can't destroy connection pool.", e);
        }
    }

//    public static Connection getConnection() throws SQLException {
//        ResourceBundle resource = ResourceBundle.getBundle("database");
//        String url = resource.getString("db.url");
//        String user = resource.getString("db.user");
//        String pass = resource.getString("db.password");
//        return DriverManager.getConnection(url, user, pass);
//    }
}
