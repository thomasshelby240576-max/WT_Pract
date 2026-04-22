import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Q1 {
   
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college", "postgres", "makasare0031");

            while (true) {
                System.out.println("\nEmployee Management System");
                System.out.println("1. Insert Employee");
                System.out.println("2. Update Employee Salary");
                System.out.println("3. Display All Employees");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertEmployee(conn, scanner);
                        break;
                    case 2:
                        updateEmployeeSalary(conn, scanner);
                        break;
                    case 3:
                        displayAllEmployees(conn);
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        conn.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private static void insertEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee Number: ");
        int eno = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        String ename = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        String sql = "INSERT INTO employee (eno, ename, salary) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, eno);
        pstmt.setString(2, ename);
        pstmt.setDouble(3, salary);
        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Employee inserted successfully.");
        } else {
            System.out.println("Failed to insert employee.");
        }
    }

    private static void updateEmployeeSalary(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee Number to update salary: ");
        int empNo = scanner.nextInt();
        System.out.print("Enter new salary: ");
        double newSalary = scanner.nextDouble();

        String sql = "UPDATE employee SET salary=? WHERE eno=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, newSalary);
        pstmt.setInt(2, empNo);
        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Salary updated successfully.");
        } else {
            System.out.println("Employee not found with given Employee Number.");
        }
    }

    private static void displayAllEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM employee";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Employee List:");
        while (rs.next()) {
            int eno = rs.getInt("eno");
            String ename = rs.getString("ename");
            double salary = rs.getDouble("salary");
            System.out.println("ENo: " + eno + ", EName: " + ename + ", Salary: " + salary);
        }
        rs.close();
    }
}
