package mate.academy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    private static final Properties DB_PROPERTIES;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    static {
        DB_PROPERTIES = new Properties();
        DB_PROPERTIES.put("user", USERNAME);
        DB_PROPERTIES.put("password", PASSWORD);

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can not load JDBC driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_PROPERTIES);
    }
}
