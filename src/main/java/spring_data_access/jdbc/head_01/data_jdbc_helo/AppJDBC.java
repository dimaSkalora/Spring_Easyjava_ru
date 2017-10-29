package spring_data_access.jdbc.head_01.data_jdbc_helo;

import java.sql.*;

//01.Hello, JDBC
public class AppJDBC {
    private static final String CREATE_QUERY =
            "CREATE TABLE EXAMPLE(GREETING_ VARCHAR(10), TARGET_ VARCHAR(10))";
    private static final String DATA_QUERY =
            "INSERT INTO EXAMPLE VALUES('Hello', 'World')";

    private AppJDBC(){}

    public static void main(String[] args) {
        //Class.forName("com.mysql.jdbc.Driver");
        try(Connection db = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/spring_easyjava","root","root")){
            try(Statement dataQuery = db.createStatement()){
                dataQuery.execute(CREATE_QUERY);
                dataQuery.execute(DATA_QUERY);
            }

            try(PreparedStatement query = db.prepareStatement(
                    "SELECT * FROM EXAMPLE")){
                ResultSet rs = query.executeQuery();
                while (rs.next()){
                    System.out.println(String.format("%s,%s!",
                            rs.getString(1),
                            rs.getString("TARGET_")));
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Database connection failure: "
                    + e.getMessage());
        }
    }
}
