package spring_data_access.jdbc.head_05.data_jdbc_errors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC statements example.
 */
public final class App {
    /**
     * Client creation query.
     */
    private static final String ADD_CLIENT =
            "INSERT INTO CLIENTS(ID, LOGIN) VALUES(?, ?)";

    /**
     * Do not construct me.
     */
    private App() {
    }

    /**
     * Entry point.
     *
     * @param args Command line args. Not used.
     */
    public static void main(final String[] args) {
        try (Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_easyjava","root","root")) {
            DatabaseSetup.setUp(db);

            try (PreparedStatement addSt = db.prepareStatement(ADD_CLIENT)) {
                addSt.setInt(1, 1);
                addSt.setString(2, "TEST");
                addSt.addBatch();

                addSt.setInt(1, 2);
                addSt.setString(2, "TEST");
                addSt.addBatch();

                addSt.executeBatch();
            } catch (SQLException ex) {
                System.out.println("SQLException message:"
                        + ex.getMessage());
                System.out.println("SQLException SQL state:"
                        + ex.getSQLState());
                System.out.println("SQLException SQL error code:"
                        + ex.getErrorCode());
            }
        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());
        }
    }
}
