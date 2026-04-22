import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Q2 {

    public static void main(String[] args) {
        try {
            // Establishing the database connection
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college", "postgres", "makasare0031");
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM teacher");

            // Moving cursor to the last row
            rs.last();

            // Getting the total number of rows
            int rowCount = rs.getRow();
            System.out.println("Total number of rows: " + rowCount);

            // Moving cursor to the first row
            rs.beforeFirst();

            // Printing the contents of the ResultSet
            System.out.println("TNO\tTName\tSubject");
            while (rs.next()) {
                int tid = rs.getInt("tno");
                String tname = rs.getString("tname");
                String salary = rs.getString("subject");
                System.out.println(tid + "\t" + tname + "\t" + salary);
            }
            // Closing the ResultSet, Statement, and Connection
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
