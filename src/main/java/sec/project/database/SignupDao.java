package sec.project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignupDao {

    private Database database;

    public SignupDao (Database database) {
        this.database = database;
    }

    public void addSignup(String name, String address, String creditcard) {
        try {
            Connection connection = database.getConnection();

            // preparedstatement works like this, right???
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO SIGNUP (name, address, creditcard) VALUES ('"
                + name + "', '"
                + address + "', '"
                + creditcard + "')"
            );
            statement.executeUpdate();
            statement.close();

            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SignupDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
