package sec.project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageDao {

    private Database database;

    public MessageDao (Database database) {
        this.database = database;
    }

    public void addMessage(String message) {
        try {
            Connection connection = database.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Message (message) VALUES (?)"
            );
            statement.setString(1, message);
            statement.executeUpdate();
            statement.close();

            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SignupDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
