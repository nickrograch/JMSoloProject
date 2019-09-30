package DAO;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class HibernateUserDAO {

    private Session session;

    public HibernateUserDAO(Session session) {
        this.session = session;
    }


    public List<User> getAllUsers() {
        Query query = session.createQuery("FROM User");
        return (List<User>) query.list();
    }
}
