import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Q2 extends Frame implements ActionListener {
    Label l1, l2, l3, l4;
    TextField t1, t2, t3,t4;
    Button b;
    Connection cn;
    Statement st;
    ResultSet rs;

    public Q2() {
        setLayout(null);
        l1 = new Label("Eno");
        l2 = new Label("EName");
        l3 = new Label("Salary");
        l4 = new Label("designation,");
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        b = new Button("Save");
        l1.setBounds(50, 50, 100, 30);
        t1.setBounds(160, 50, 100, 30);
        l2.setBounds(50, 90, 100, 30);
        t2.setBounds(160, 90, 100, 30);
        l3.setBounds(50, 130, 100, 30);
        t3.setBounds(160, 130, 100, 30);
        l4.setBounds(50, 130, 100, 30);
        t4.setBounds(160, 130, 100, 30);
        b.setBounds(50, 170, 100, 30);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(b);
        b.addActionListener(this);
        setSize(500, 500);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent oe) {
        String str = oe.getActionCommand();
        if (str.equals("Save")) {
            try {
                Class.forName("org.postgresql.Driver");
                cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college", "postgres", "makasare0031");
                st = cn.createStatement();
                int en = Integer.parseInt(t1.getText());
                String enn = t2.getText();
                int sal = Integer.parseInt(t3.getText());
                String des = t4.getText();
                String query = "INSERT INTO employee (eno, ename,designation, salary) VALUES (" + en + ", '" + enn + "', '" + des + "'," + sal + ")";
                int k = st.executeUpdate(query);
                if (k > 0) {
                    JOptionPane.showMessageDialog(null, "Record Is Added");
                }
            } catch (Exception er) {
                er.printStackTrace();
            } finally {
                try {
                    if (st != null)
                        st.close();
                    if (cn != null)
                        cn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        new Q2();
    }
}
