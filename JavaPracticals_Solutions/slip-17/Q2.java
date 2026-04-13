import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Q2 implements Runnable { 
    private JTextField textField; 
 
    public Q2(JTextField textField) { 
        this.textField = textField; 
    } 
 
    @Override 
    public void run() { 
        for (int i = 1; i <= 100; i++) {
            textField.setText(Integer.toString(i)); 
            try { 
                Thread.sleep(100); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
    public static void main(String[] args) { 
        JFrame frame = new JFrame("Number Display"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JTextField textField = new JTextField(10); 
        JButton button = new JButton("Start"); 
        JPanel panel = new JPanel(); 
        panel.add(textField); 
        panel.add(button); 
        frame.add(panel); 
        frame.pack(); 
        frame.setVisible(true); 
        button.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                Q2 numberDisplay = new Q2(textField); 
                Thread thread = new Thread(numberDisplay); 
                thread.start();
            } 
        }); 
    } 
}

