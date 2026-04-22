import javax.swing.*;

public class Q2 implements Runnable {
    private JTextField textField;

    public Q2(JTextField textField) {
        this.textField = textField;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            textField.setText(String.valueOf(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Start");

        JFrame frame = new JFrame("Number Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JPanel() {{
            add(textField);
            add(button);
        }});
        frame.pack();
        frame.setVisible(true);

        button.addActionListener(e -> new Thread(new Q2(textField)).start());
    }
}