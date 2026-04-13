import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class ProjectDisplay extends JFrame implements ActionListener {
    Connection con;

    static JTable table;
    String[] columnNames = { "pid", "pname", "pdescription" };
    JFrame frm;
    JPanel p1;
    String p_id = "", p_name = "", p_description = "";

    JButton Insert, Display, Exit;

    ProjectDisplay() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PROJECT INFORMATION");
        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 5, 30, 30));
        Insert = new JButton("Insert");
        p1.add(Insert);
        Display = new JButton("Display");
        p1.add(Display);
        Exit = new JButton("Exit");
        p1.add(Exit);

        Insert.addActionListener(this);
        Display.addActionListener(this);
        Exit.addActionListener(this);
        add(p1, BorderLayout.CENTER);
        setVisible(true);
        setSize(600, 600);

        connectToDatabase(); // Establish database connection
    }

    private void connectToDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            // Use database name & password according to your "dbname","pass"
            con = DriverManager.getConnection("jdbc:postgresql://localhost/student", "postgres", "srv001");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Display) {
            displayRecords();
        } else if (ae.getSource() == Insert) {
            new Insert(this);
        } else if (ae.getSource() == Exit) {
            System.exit(0);
        }
    }

    private void displayRecords() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM project");

            while (rs.next()) {
                p_id = rs.getString(1);
                p_name = rs.getString(2);
                p_description = rs.getString(3);
                model.addRow(new Object[] { p_id, p_name, p_description });
            }

            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            JOptionPane.showMessageDialog(this, scrollPane, "Project Records", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    class Insert extends JFrame implements ActionListener {
        JTextField txtpid, txtpname, txtdsc;
        JButton btnadd, btnclear;

        Insert(JFrame parent) {
            setTitle("Project Record Inserts");
            setSize(400, 500);
            setVisible(true);
            setLayout(new GridLayout(6, 2, 40, 40));
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JLabel id = new JLabel("Enter Project number: ");
            add(id);
            txtpid = new JTextField(10);
            add(txtpid);

            JLabel name = new JLabel("Enter Project Name: ");
            add(name);
            txtpname = new JTextField(10);
            add(txtpname);

            JLabel dsc = new JLabel("Enter Project Description: ");
            add(dsc);
            txtdsc = new JTextField(10);
            add(txtdsc);

            btnadd = new JButton("Insert");
            add(btnadd);
            btnadd.addActionListener(this);

            btnclear = new JButton("Cancel");
            add(btnclear);
            btnclear.addActionListener(this);
        }

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnadd) {
                insertRecord();
            } else if (ae.getSource() == btnclear) {
                clearFields();
            }
        }

        private void insertRecord() {
            try {
                int p_id = Integer.parseInt(txtpid.getText());
                String pname = txtpname.getText();
                String ds = txtdsc.getText();

                PreparedStatement pstmt = con.prepareStatement("INSERT INTO project VALUES (?, ?, ?)");
                pstmt.setInt(1, p_id);
                pstmt.setString(2, pname);
                pstmt.setString(3, ds);

                int result = pstmt.executeUpdate();
                if (result == 1) {
                    JOptionPane.showMessageDialog(null, "Successfully Inserted", pname, JOptionPane.INFORMATION_MESSAGE);
                }

                pstmt.close();
            } catch (SQLException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void clearFields() {
            txtpid.setText("");
            txtpname.setText("");
            txtdsc.setText("");
        }
    }

    public static void main(String arg[]) {
        new ProjectDisplay();
    }
}
/*
postgres=# CREATE DATABASE student;
CREATE DATABASE
postgres=# \c student;
You are now connected to database "student" as user "postgres".
student=# CREATE TABLE project(pid INT, pname VARCHAR(255), pdescription VAECHAR(255));
ERROR:  type "vaechar" does not exist
LINE 1: ...project(pid INT, pname VARCHAR(255), pdescription VAECHAR(25...
                                                             ^
student=# CREATE TABLE project(pid INT, pname VARCHAR(255), pdescription VARCHAR(255));
CREATE TABLE
student=# SELECT * FROM project;
 pid | pname | pdescription
-----+-------+--------------
(0 rows)

student=# */