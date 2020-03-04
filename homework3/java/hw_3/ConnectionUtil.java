package hw_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/garage?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "qwerty";

    protected static Connection getConnection(){
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Problem with connect to database");
        }
    }

}
