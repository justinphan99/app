package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static final String url = "jdbc:postgresql://localhost:5432/JobQueueSystem";
    public static final String username = "postgres";
    public static final String password = "10091999";

    public static Connection getConnection() {
        Connection cnt = null;
        try {
            cnt = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to PostgreSQL");
            return cnt;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection cnt = getConnection();
    }
}
