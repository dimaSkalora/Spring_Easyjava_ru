package spring_data_access.jdbc.head_05.data_jdbc_errors;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Creates database tables and initializes them with data.
 */
public final class DatabaseSetup {
    /**
     * Query that creates clients table.
     */
    private static final String CREATE_CLIENT =
            "CREATE TABLE CLIENTS ("
                    + "ID  INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                    + "LOGIN VARCHAR(8) NOT NULL UNIQUE"
                    + ")";

    /**
     * Do not construct me.
     */
    private DatabaseSetup() { }

    /**
     * Here we create tables and populate them with sample data.
     * @param db Database connection object.
     * @throws SQLException when something goes wrong.
     */
    public static void setUp(final Connection db) throws SQLException {
        try (Statement dataQuery = db.createStatement()) {
            dataQuery.execute(CREATE_CLIENT);
        }
    }

}
