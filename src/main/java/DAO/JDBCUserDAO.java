package DAO;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDAO {

    private Connection connection;
    public JDBCUserDAO(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAllUsers() throws SQLException{
        List<User> list = new ArrayList<>();
        createTable();
        Statement stmt = connection.createStatement();
        stmt.execute("select * from users");
        ResultSet resultSet = stmt.getResultSet();
        while (resultSet.next()){
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String fathername = resultSet.getString("fathername");
            User user = new User(id, name, surname, fathername);
            list.add(user);
        }
        return list;
    }

    public void addUser(User user) throws SQLException  {
        String query = "INSERT INTO users (name, surname, fathername) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSurname());
        stmt.setString(3, user.getFatherName());
        try {
            stmt.executeUpdate();
        }
        catch (SQLException e){
            throw new SQLException();
        }

    }


    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists users (id bigint auto_increment, name varchar(256), " +
                "surname varchar(256), fathername varchar(256), primary key (id))");
        stmt.close();
    }
}
