import java.sql.*;

public class Q1 {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/postgres", "postgres", "dsk");

            DatabaseMetaData db = conn.getMetaData();

            System.out.println("\n---------------------------------------------");
            System.out.println("Driver: " + db.getDriverName());
            System.out.println("Version: " + db.getDriverVersion());
            System.out.println("User: " + db.getUserName());
            System.out.println("DB: " + db.getDatabaseProductName());
            System.out.println("DB Version: " + db.getDatabaseProductVersion());
            System.out.println("---------------------------------------------");

            ResultSet rs = db.getTables(null, null, null, new String[]{"TABLE"});
            System.out.println("Tables:");

            while (rs.next())
                System.out.println(rs.getString("TABLE_NAME"));

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}