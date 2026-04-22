import java.sql.*;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/college", "postgres", "makasare0031");
            Scanner sc = new Scanner(System.in)
        ) {
            System.out.println("Connected to database");

            // Input
            System.out.print("Enter Pid: ");
            int pid = sc.nextInt(); sc.nextLine();

            System.out.print("Enter Pname: ");
            String pname = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            // Insert
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO product VALUES (?, ?, ?)");
            pst.setInt(1, pid);
            pst.setString(2, pname);
            pst.setDouble(3, price);
            pst.executeUpdate();

            // Display
            ResultSet rs = con.createStatement()
                              .executeQuery("SELECT * FROM product");

            System.out.println("\nProduct Records:");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " "
                        + rs.getString(2) + " "
                        + rs.getDouble(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}