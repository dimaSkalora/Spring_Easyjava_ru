package spring_data_access.jdbc.head_02.data_jdbc_statement;

import java.sql.*;

//02.JDBC statements
public class AppJdbc {
    /**
     * Number of items in order.
     */
    private static final int MAX_ITEMS = 5;

    /**
     * We only ha3 clients.
     */
    private static final int MAX_CLIENTS = 3;

    /**
     * Query that create table.
     */
    private static final String CREATE_QUERY =
            "CREATE TABLE ORDER_ITEMS ("
                    + "ID INTEGER NOT NULL PRIMARY KEY, "
                    + "CLIENT_ID INTEGER NOT NULL, "
                    + "ORDER_ID INTEGER NOT NULL, "
                    + "ITEM_ID INTEGER NOT NULL"
                    + ")";


    private AppJdbc(){}

    public static void main(String[] args) {
        //Class.forName("com.mysql.jdbc.Driver");
        try(Connection db = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/spring_easyjava","root","root")){
            try (Statement dataQuery = db.createStatement()) {
               // dataQuery.execute(CREATE_QUERY);

                for (int i = 1; i <= MAX_ITEMS; i++) {
                    dataQuery.executeUpdate("INSERT INTO ORDER_ITEMS "
                            + "(CLIENT_ID, ORDER_ID, ITEM_ID) "
                            + "values (1, 1, " + i + ")");
                }
            }

            try (PreparedStatement query =
                         db.prepareStatement("INSERT INTO ORDER_ITEMS "
                                 + "(CLIENT_ID, ORDER_ID, ITEM_ID) "
                                 + "values (1, 2, ?)")) {
                for (int i = 1; i <= MAX_ITEMS; i++) {
                    query.setInt(1, i);
                    query.executeUpdate();
                }
            }

            try (PreparedStatement batch =
                         db.prepareStatement("INSERT INTO ORDER_ITEMS "
                                 + "(CLIENT_ID, ORDER_ID, ITEM_ID) "
                                 + "values (1, ?, ?)")) {
                for (int i = 1; i <= MAX_ITEMS; i++) {
                    batch.setInt(1, MAX_CLIENTS);
                    batch.setInt(2, i);
                    batch.addBatch();
                }
                batch.executeBatch();
            }

            try (Statement results = db.createStatement()) {
                try (ResultSet rs =
                             results.executeQuery("SELECT * FROM ORDER_ITEMS")) {
                    while (rs.next()) {
                        System.out.println(
                                String.format(
                                        "client=%d, order=%d, item=%d",
                                        rs.getInt("CLIENT_ID"),
                                        rs.getInt("ORDER_ID"),
                                        rs.getInt("ITEM_ID")));
                    }
                }
            }

            try (CallableStatement upperProc =
                         db.prepareCall("{ ? = call upper( ? ) }")) {
                upperProc.registerOutParameter(1, Types.VARCHAR);
                upperProc.setString(2, "lowercase to uppercase");
                upperProc.execute();
                System.out.println(upperProc.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());
        }
    }
}
