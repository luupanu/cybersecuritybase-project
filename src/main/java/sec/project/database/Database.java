package sec.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String address;

    public Database(String address) {
        this.address = address;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.address, "sa", "");
    }
}
