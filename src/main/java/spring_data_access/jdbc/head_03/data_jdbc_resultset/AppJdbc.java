package spring_data_access.jdbc.head_03.data_jdbc_resultset;

import com.sun.rowset.*;

import javax.sql.RowSet;
import javax.sql.rowset.*;
import java.io.IOException;
import java.sql.*;


//03.JDBC ResultSet и RowSet
public class AppJdbc {
    /**
     * ID of additional item.
     */
    private static final int ADDITIONAL_ITEM = 10;

    /**
     * We are going to modify that row.
     */
    private static final int FIFTH_ROW = 5;


    public static void main(String[] args) {
        //Class.forName("com.mysql.jdbc.Driver");
        try(Connection db = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/spring_easyjava","root","root")){
            //Чтение из ResultSet
            readResultSet(db);
            //Запись в ResultSet
            updateResultSet(db);
            //RowSet
            jdbcRowSet(db);
            //CachedRowSet
            cachedRowSet(db);
            //JoinRowSet
           // joinRowSet(db);
            //FilteredRowSet
            filteredRowSet(db);
            //WebRowSet
            try {
                webRowSet(db);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());
        }
    }

    /**
     * Example of ResultSet usage.
     * @param db Database connection object.
     * @throws SQLException when soemthing goes wrong.
     */
    protected static void readResultSet(final Connection db)
            throws SQLException {
        System.out.println("Dumping ORDER_ITEMS table:");
        try (Statement results = db.createStatement()) {
            try (ResultSet rs =
                         results.executeQuery("SELECT * FROM ORDER_ITEMS")) {
                while (rs.next()) {
                    System.out.println(
                            String.format(
                                    "id=%d, client=%d, order=%d, item=%d",
                                    rs.getInt("ID"),
                                    rs.getInt("CLIENT_ID"),
                                    rs.getInt("ORDER_ID"),
                                    rs.getInt(4)));
                }
            }
        }
    }

    /**
     * Example of updatable ResultSet.
     * @param db Database connection object.
     * @throws SQLException when something goes wrong.
     */
    protected static void updateResultSet(final Connection db)
            throws SQLException {
        try (Statement updatableResult
                     = db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            try (ResultSet rs =
                         updatableResult.executeQuery("SELECT * FROM ORDER_ITEMS")) {
                rs.absolute(FIFTH_ROW);
                rs.updateInt("CLIENT_ID", 2);
                rs.updateRow();

                rs.moveToInsertRow();
                rs.updateInt("CLIENT_ID", 1);
                rs.updateInt("ORDER_ID", 1);
                rs.updateInt("ITEM_ID", ADDITIONAL_ITEM);
                rs.insertRow();
            }
        }
    }

    /**
     * Example of JdbcRowSet usage.
     * @param db Database connection object.
     * @throws SQLException when something goes wrong.
     */
    protected static void jdbcRowSet(final Connection db)
            throws SQLException {
        JdbcRowSet rs = new JdbcRowSetImpl(db);
        rs.setCommand("SELECT * FROM ORDER_ITEMS");
        rs.execute();

        rs.moveToInsertRow();
        rs.updateInt("CLIENT_ID", 1);
        rs.updateInt("ORDER_ID", 1);
        rs.updateInt("ITEM_ID", ADDITIONAL_ITEM + 1);
        rs.insertRow();

        rs.execute();
        rs.beforeFirst();
        System.out.println("Dumping ORDER_ITEMS table using RowSet:");
        while (rs.next()) {
            System.out.println(
                    String.format(
                            "client=%d, order=%d, item=%d",
                            rs.getInt("CLIENT_ID"),
                            rs.getInt("ORDER_ID"),
                            rs.getInt("ITEM_ID")));
        }
    }

    /**
     * Exampl of CachedRowSet usage.
     * @param db Database connection object.
     * @return CachedRowSet object with data.
     * @throws SQLException when something goes wrong.
     */
    protected static CachedRowSet cachedRowSet(final Connection db)
            throws SQLException {
        try (Statement results = db.createStatement()) {
            ResultSet rs =
                    results.executeQuery("SELECT * FROM ORDER_ITEMS");
            CachedRowSet cs = new CachedRowSetImpl();
            cs.populate(rs);

            return cs;
        }
    }

    /**
     * Example of JoinRowSet usage.
     * @param db Database connection object.
     * @throws SQLException when something goes wrong.
     */
    protected static void joinRowSet(final Connection db)
            throws SQLException {
        CachedRowSet orders = new CachedRowSetImpl();
        CachedRowSet clients = new CachedRowSetImpl();
        try (Statement results = db.createStatement()) {
            try (ResultSet rs =
                         results.executeQuery("SELECT * FROM ORDER_ITEMS")) {
                orders.populate(rs);
            }
        }
        try (Statement results = db.createStatement()) {
            try (ResultSet rs =
                         results.executeQuery("SELECT * FROM CLIENTS")) {
                clients.populate(rs);
            }
        }
        JoinRowSet jrs = new JoinRowSetImpl();
        jrs.addRowSet(orders, "CLIENT_ID");
        jrs.addRowSet(clients, "ID");

        System.out.println("Dumping client logins and their items:");
        while (jrs.next()) {
            System.out.println(
                    String.format(
                            "client=%s, order=%d",
                            jrs.getString("LOGIN"),
                            jrs.getInt("ORDER_ID")));
        }
    }

    /**
     * Example of JDBC's Predicate interface implementation.
     */
    private static class ClientFilter implements Predicate {

        @Override
        public boolean evaluate(final RowSet rs) {
            try {
                return rs.getInt("CLIENT_ID") == DatabaseSetup.MAX_CLIENTS;
            } catch (SQLException e) {
                return false;
            }
        }

        @Override
        public boolean evaluate(final Object value, final int column)
                throws SQLException {
            return !(column == 1 && !"3".equals(value));

        }

        @Override
        public boolean evaluate(final Object value, final String columnName)
                throws SQLException {
            return !("CLIENT_ID".equals(columnName)
                    && !"3".equals((String) value));
        }
    }

    /**
     * Example of FilteredRowSet usage.
     * @param db Database connection object.
     * @throws SQLException when something goes wrong.
     */
    protected static void filteredRowSet(final Connection db)
            throws SQLException {
        try (Statement results = db.createStatement()) {
            try (ResultSet rs =
                         results.executeQuery("SELECT * FROM ORDER_ITEMS")) {
                FilteredRowSet fs = new FilteredRowSetImpl();
                fs.populate(rs);

                fs.setFilter(new ClientFilter());

                System.out.println("Dumping only 3rd client from ORDER_ITEMS:");
                while (fs.next()) {
                    System.out.println(
                            String.format(
                                    "client=%d, order=%d, item=%d",
                                    fs.getInt("CLIENT_ID"),
                                    fs.getInt("ORDER_ID"),
                                    fs.getInt("ITEM_ID")));
                }
            }
        }
    }

    /**
     * Example of webRowSet.
     * @param db Database connection object.
     * @throws SQLException when something goes wrong.
     * @throws IOException when not able to form XML.
     */
    protected static void webRowSet(final Connection db)
            throws SQLException, IOException {
        try (Statement results = db.createStatement()) {
            try (ResultSet rs =
                         results.executeQuery("SELECT * FROM ORDER_ITEMS")) {
                WebRowSet ws = new WebRowSetImpl();
                ws.populate(rs);

                ws.writeXml(System.out);
            }
        }

    }
}
