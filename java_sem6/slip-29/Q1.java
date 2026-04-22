import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Q1 {
    public static void main(String[] args) {
        try {
            // load a driver
            Class.forName("org.postgresql.Driver");
            // Establish Connection
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/college", "postgres", "makasare0031");

            //Statement stmt = null;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM donor");

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("-------------------------------------------------");

            int count = rsmd.getColumnCount();
            System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
            System.out.println("-------------------------------------------------");
            for (int i = 1; i <= count; i++) 
            {
                System.out.println("Column No : " + i);
                System.out.println("Column Name : " + rsmd.getColumnName(i));
                System.out.println("Column Type : " + rsmd.getColumnTypeName(i));
                System.out.println("Column Display Size : " + rsmd.getColumnDisplaySize(i));
                System.out.println();
            } // for
            System.out.println("--------------------------------------------------");

            rs.close();
            stmt.close();
            conn.close();
        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch
    }
}
