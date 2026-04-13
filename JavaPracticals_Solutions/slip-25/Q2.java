import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Q2 {

    // Update these variables with your PostgreSQL database credential

    public static void main(String[] args) {
        JFrame frame = new JFrame("DDL Query Executor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JTextField queryField = new JTextField();

        JButton createButton = new JButton("Create Table");
        JButton alterButton = new JButton("Alter Table");
        JButton dropButton = new JButton("Drop Table");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(alterButton);
        buttonPanel.add(dropButton);

        frame.add(queryField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = queryField.getText();
                executeQuery(query);
            }
        });

        alterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = queryField.getText();
                executeQuery(query);
            }
        });

        dropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = queryField.getText();
                executeQuery(query);
            }
        });
    }

    private static void executeQuery(String query) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college", "postgres", "makasare0031");
            Statement st = conn.createStatement();
            int rowsAffected = st.executeUpdate(query);
            System.out.println(rowsAffected + " rows affected.");
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
