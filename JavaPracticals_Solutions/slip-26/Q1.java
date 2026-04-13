import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Id to delete record: ");
        int employeeId = sc.nextInt();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college", "postgres", "makasare0031");

            String deleteQuery = "DELETE FROM employee WHERE eno = ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, employeeId);
            int rowsAffected = pstmt.executeUpdate();

            // Closing resources
            pstmt.close();
            conn.close();
            sc.close();

            if (rowsAffected > 0) {
                System.out.println("Employee details deleted successfully.");
            } else {
                System.out.println("No employee found with ID: " + employeeId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}