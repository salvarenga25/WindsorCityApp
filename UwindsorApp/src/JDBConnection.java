
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnection { //this class  is only for testing the connection between java and Oracle db

    public static void main(String[] args) {

        // https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html#package.description
        // auto java.sql.Driver discovery -- no longer need to load a java.sql.Driver class via Class.forName

        // register JDBC driver, optional since java 1.6
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Oracle SID = orcl , find yours in tnsname.ora

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@anip:1521:orcl", "user", "password")) { //these fields are hidden for protection of my db -Salvador

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
          Statement stmt=conn.createStatement(); 
          ResultSet rs = stmt.executeQuery("Select * from T_PRI_F1DRIVERS");
          while(rs.next()){
              System.out.println(rs.getInt(1)+ "\t\t "+rs.getString(2)+"\t "+rs.getString(3)+"\t "+rs.getInt(4));
          }
          
          
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
