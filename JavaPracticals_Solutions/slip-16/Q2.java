import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Register JDBC driver
            Class.forName("org.postgresql.Driver");
            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college", "postgres", "makasare0031");

            // Accept details of teachers
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 1; i++) {
                System.out.println("Enter teacher details for record " + (i + 1));
                System.out.print("Teacher Number: ");
                int tno = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.print("Teacher Name: ");
                String tname = sc.nextLine();
                System.out.print("Subject: ");
                String subject = sc.nextLine();

                // Insert record into Teacher table
                String sql = "INSERT INTO teacher (tNo, tName, subject) VALUES (?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, tno);
                pstmt.setString(2, tname);
                pstmt.setString(3, subject);
                pstmt.executeUpdate();
            }

            // Display details of teachers teaching "JAVA" subject
            System.out.println("Details of teachers teaching JAVA subject:");
            String sql = "SELECT * FROM teacher WHERE subject = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "java");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int tno = rs.getInt("tNo");
                String tname = rs.getString("tName");
                String sub = rs.getString("subject");
                System.out.println("TNo: " + tno + ", TName: " + tname + ", Subject: " + sub);
            }
            // Clean-up environment
            rs.close();
            pstmt.close();
            conn.close();
            sc.close();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}
