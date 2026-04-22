import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class Q2 extends Frame implements ActionListener {

    TextField t1, t2, t3, t4;
    Button b;

    public Q2() {
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new Label("Eno"));
        t1 = new TextField();
        add(t1);

        add(new Label("EName"));
        t2 = new TextField();
        add(t2);

        add(new Label("Salary"));
        t3 = new TextField();
        add(t3);

        add(new Label("Designation"));
        t4 = new TextField();
        add(t4);

        b = new Button("Save");
        add(b);

        b.addActionListener(this);

        setSize(300, 250);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection cn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/college",
                "postgres",
                "makasare0031"
            );

            Statement st = cn.createStatement();

            String query = "INSERT INTO employee VALUES ('"
                    + t1.getText() + "','"
                    + t2.getText() + "','"
                    + t4.getText() + "','"
                    + t3.getText() + "')";

            if (st.executeUpdate(query) > 0) {
                JOptionPane.showMessageDialog(this, "Record Is Added");
            }

            st.close();
            cn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Q2();
    }
}