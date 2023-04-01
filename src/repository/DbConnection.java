package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DbConnection {
    public static Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/gym2";
        String username = "postgres";
        String password = "h.elcin78";
        return DriverManager.getConnection(url, username, password);
    }
}
