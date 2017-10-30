package spring_data_access.jdbc.head_06.data_jdbc_types;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

/**
 * JDBC statements example.
 */
public final class App {
    /**
     * Blob upload query.
     */
    private static final String ADD_BLOB =
            "UPDATE postoffice SET PHOTO=? WHERE ID=1";

    /**
     * Do not construct me.
     */
    private App() {
    }

    /*public class Address implements SQLData {
        public String city;
        public String street;
        public Integer building;
        private String sql_type;
        @Override
        public String getSQLTypeName() throws SQLException {
            return sql_type;
        }
        @Override
        public void readSQL(SQLInput stream, String typeName)
           throws SQLException {
            sql_type = typeName;
            city = stream.readString();
            street = stream.readString();
            building = stream.readInt();
        }
        @Override
        public void writeSQL(SQLOutput stream) throws SQLException {
            stream.writeString(city);
            stream.writeString(street);
            stream.writeInt(building);
        }
    }*/

    /**
     * Entry point.
     *
     * @param args Command line args. Not used.
     */
    public static void main(final String[] args) {
        try (Connection db = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1/types?user=types&password=types")) {

            try (InputStream blobSource = App.class
                    .getClassLoader()
                    .getResourceAsStream("Blob.jpg")) {
               // System.out.println("Uploaded file md5 is: "
                       // + DigestUtils.md5Hex(blobSource));
            }
            try (InputStream blobSource =
                         App.class
                                 .getClassLoader()
                                 .getResourceAsStream("Blob.jpg")) {
                try (PreparedStatement uploadSt =
                             db.prepareStatement(ADD_BLOB)) {
                    uploadSt.setBinaryStream(1, blobSource);
                    uploadSt.executeUpdate();
                }

                try (Statement downloadSt = db.createStatement()) {
                    try (ResultSet rs =
                                 downloadSt.executeQuery(
                                         "SELECT photo FROM postoffice WHERE id=1")) {
                        rs.next();

                       // System.out.println("Downloaded file md5 is: "
                         //       + DigestUtils.md5Hex(rs.getBinaryStream("photo")));
                    }
                }
            }

            try (Statement arraySt = db.createStatement()) {
                try (ResultSet rs =
                             arraySt.executeQuery(
                                     "SELECT employees FROM postoffice WHERE id=1")) {
                    rs.next();
                    Stream.of((String[]) rs.getArray("employees")
                            .getArray())
                            .forEach(System.out::println);

                }
            }

            try (Statement zipSt = db.createStatement()) {
                try (ResultSet rs =
                             zipSt.executeQuery(
                                     "SELECT code FROM postoffice WHERE id=1")) {
                    rs.next();
                    System.out.println("Zip code is:" + rs.getString("code"));
                }
            }
            /*
            Map<String, Class<?>> typeMap = db.getTypeMap;
            typeMap.put("STREETADDRESS", Address.class);
            db.setTypeMap(typeMap);
            try (Statement typeSt = db.createStatement()) {
                try (ResultSet rs =
             typeSt.executeQuery("SELECT address FROM postoffice WHERE id=1")) {
                    rs.next();
                    Address address = (Address)rs.getObject("address");
                    System.out.println("City: " + address.city);
                    System.out.println("Street: " + address.street);
                    System.out.println("Building: "
                      + address.building.toString());
                }
            }*/
        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O failure: "
                    + ex.getMessage());
        }

    }
}
