import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class FlagDrawer extends JPanel implements Runnable {
    int width = 400;
    int height = 200;
    int stripe = height / 3;
    int radius = 25;

    private boolean running;

    public FlagDrawer() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        running = false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the saffron stripe
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, width, stripe);

        // Draw the white stripe
        g.setColor(Color.WHITE);
        g.fillRect(0, stripe, width, stripe);

        // Draw the green stripe
        g.setColor(Color.GREEN);
        g.fillRect(0, stripe * 2, width, stripe);

        // Draw the blue circle
        g.setColor(Color.BLUE);
        // (width/2 - radius, height/2 - radius, radius*2, raduis*2)
        g.fillOval(width/2 - radius, height/2 - radius, radius*2, radius*2);
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }
}

public class Q1 extends JFrame {
    public Q1() {
        setTitle("Indian Flag");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlagDrawer flagDrawer = new FlagDrawer();
        add(flagDrawer, BorderLayout.CENTER);    
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q1::new);
    }
}