package service;

import DAO.HibernateUserDAO;
import DAO.JDBCUserDAO;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;
import util.PropertiesReader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService userService;
    private SessionFactory sessionFactory;
    private Connection connection;

    public UserService (){
    }

    private UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private UserService(Connection connection){this.connection = connection;}

    public static UserService getInstance() {
        if (userService == null) {
            if (PropertiesReader.getInstance().getDBConnectionType().equals("hibernate")) {
                userService = new UserService(DBHelper.getSessionFactory());
            }
            else if (PropertiesReader.getInstance().getDBConnectionType().equals("JDBC")){
                userService = new UserService(getMysqlConnection());
            }
        }
        return userService;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try {
            if (PropertiesReader.getInstance().getDBConnectionType().equals("hibernate")) {
                Session session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();
                HibernateUserDAO userDAO = new HibernateUserDAO(session);
                users = userDAO.getAllUsers();
                transaction.commit();
                session.close();
            }
            else if (PropertiesReader.getInstance().getDBConnectionType().equals("JDBC")){
                users =  getJDBCUserDAO().getAllUsers();
            }
        } catch (HibernateException | SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName(PropertiesReader.getInstance().getDriver()).newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append(PropertiesReader.getInstance().getUrl()).  //url
                    append("?").
                    append(PropertiesReader.getInstance().getUsername()).
                    append(PropertiesReader.getInstance().getPassword());

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static JDBCUserDAO getJDBCUserDAO() {
        return new JDBCUserDAO(getInstance().connection);
    }
}
