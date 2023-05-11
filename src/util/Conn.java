
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
      private static Connection mysqlconfig;
    public static Connection configDB() throws SQLException{
        try {
            String url = "jdbc:mysql://localhost/db_rahmatan";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.err.println("koneksi gagal " + e.getLocalizedMessage());
        }
        return mysqlconfig;
}
    public static Connection getConnection() {
        return mysqlconfig;
    }
}
