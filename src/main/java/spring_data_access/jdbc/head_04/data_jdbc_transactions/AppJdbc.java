package spring_data_access.jdbc.head_04.data_jdbc_transactions;

import java.sql.*;

//04.JDBC транзакции
public class AppJdbc {
    /**
     * ID of additional item.
     */
    private static final int ADDITIONAL_ITEM = 10;

    /**
     * We are going to modify that row.
     */
    private static final int FIFTH_ROW = 5;

    /**
     * Price of a single order item.
     */
    private static final int ORDER_PRICE = 50;

    /**
     * Order item creation query.
     */
    private static final String ADD_ITEM =
            "INSERT INTO ORDER_ITEMS "
                    + "(CLIENT_ID, ORDER_ID, ITEM_ID)"
                    + "VALUES(?, ?, ?)";

    /**
     * Account statement.
     */
    private static final String GET_ACCOUNT =
            "SELECT ID, ACCOUNT FROM CLIENTS WHERE ID = ?";

    /**
     * Adds item to the order and decreases client's account balance.
     * @param db Database connection object.
     * @param itemId Item id to add.
     * @throws SQLException when something goes wrong.
     */
    protected static void addOrder(final Connection db, final int itemId)
            throws SQLException {
        try (PreparedStatement itemStatement = db.prepareStatement(ADD_ITEM)) {
            itemStatement.setInt(1, 1);
            itemStatement.setInt(2, 1);
            itemStatement.setInt(DatabaseSetup.CLIENT_ID, itemId);

            itemStatement.execute();
        }


        try (PreparedStatement accountStatement
                     = db.prepareStatement(GET_ACCOUNT,
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            accountStatement.setInt(1, 1);
            try (ResultSet rs = accountStatement.executeQuery()) {
                rs.next();
                int value = rs.getInt("ACCOUNT");
                value -= ORDER_PRICE;
                rs.updateInt("ACCOUNT", value);
                rs.updateRow();
            }
        }
    }

    /**
     * Prints current client and order data from database.
     * @param db Database connection object.
     * @throws SQLException when something goes wrong.
     */
    protected static void printClientData(final Connection db)
            throws SQLException {
        try (PreparedStatement clientQuery =
                     db.prepareStatement("SELECT * FROM CLIENTS WHERE id=1")) {
            try (ResultSet rs = clientQuery.executeQuery()) {
                rs.next();
                System.out.println(
                        String.format("Client login: %s, client account: %d",
                                rs.getString("LOGIN"),
                                rs.getInt("ACCOUNT")));
            }
        }

        try (PreparedStatement orderQuery =
                     db.prepareStatement("SELECT * FROM ORDER_ITEMS_2 WHERE client_id=1")) {
            try (ResultSet rs = orderQuery.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                            String.format("Order id: %d, item id: %d",
                                    rs.getInt("ORDER_ID"),
                                    rs.getInt("ITEM_ID")));

                }
            }
        }
    }

    /**
     * Entry point.
     *
     * @param args Command line args. Not used.
     */
    public static void main(final String[] args) {
        try (Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_easyjava","root","root")) {
            DatabaseSetup.setUp(db);

            db.setAutoCommit(false);
            System.out.println("Initial client data:");
            printClientData(db);

            addOrder(db, FIFTH_ROW);
            db.commit();
            System.out.println("Client data after one item:");
            printClientData(db);

            addOrder(db, FIFTH_ROW);
            addOrder(db, FIFTH_ROW);
            db.rollback();
            System.out.println("Client data after three items and rollback:");
            printClientData(db);

            //Savepoints
            addOrder(db, FIFTH_ROW);
            Savepoint firstItem = db.setSavepoint("first");
            addOrder(db, FIFTH_ROW);
            Savepoint secondItem = db.setSavepoint("second");
            addOrder(db, ADDITIONAL_ITEM);
            Savepoint thirdItem = db.setSavepoint("third");
            System.out.println("Client data after three savepoints:");
            printClientData(db);
            db.rollback(secondItem);
            System.out.println("Client data after first savepoint:");
            printClientData(db);
            db.releaseSavepoint(firstItem);
            db.releaseSavepoint(thirdItem);
            //db.rollback(firstItem); //This line will throw an SQLException
            db.commit();
            System.out.println("Client data after another item and commit:");
            printClientData(db);

        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());
        }
    }
}
