import java.applet.*;
import java.awt.*;

public class Q2 extends Applet implements Runnable {
    Thread t;
    int r, g1, y, i;

    public void init() {
        t = new Thread(this);
        t.start();
        r = 0;
        g1 = 0;
        i = 0;
        y = 0;
    }
    public void run() {
        try {
            for (int i = 24; i >= 1; i--) {
                if (i > 16 && i <= 24) { //If i is between 17 and 24, it sets the r variable to 1, indicating that the red signal is on.
                    t.sleep(200);
                    r = 1;
                    repaint();
                }
                if (i > 8 && i <= 16) { //If i is between 9 and 16, it sets the y variable to 1, indicating that the yellow signal is on
                    t.sleep(200);
                    y = 1;
                    repaint();
                }
                if (i > 1 && i <= 8) { //If i is between 1 and 8, it sets the g1 variable to 1, indicating that the green signal is on
                    t.sleep(200);
                    g1 = 1;
                    repaint();
                }
            }
            if (i == 0) {
                run();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void paint(Graphics g) {
        g.drawRect(100, 100, 100, 300);
        if (r == 1) {
            g.setColor(Color.red);
            g.fillOval(100, 100, 100, 100);
            g.setColor(Color.black);
            g.drawOval(100, 200, 100, 100);
            g.drawOval(100, 300, 100, 100);
            r = 0;
        }
        if (y == 1) {
            g.setColor(Color.black);
            g.drawOval(100, 100, 100, 100);
            g.drawOval(100, 300, 100, 100);
            g.setColor(Color.yellow);
            g.fillOval(100, 200, 100, 100);
            y = 0;
        }
        if (g1 == 1) {
            g.setColor(Color.black);
            g.drawOval(100, 100, 100, 100);
            g.drawOval(100, 200, 100, 100);
            g.setColor(Color.green);
            g.fillOval(100, 300, 100, 100);
            g1 = 0;
        }
    }
    public static void main(String[] args) {
        Q2 applet = new Q2();
        Frame frame = new Frame("Traffic Signal Simulation");
        frame.add(applet);
        frame.setSize(300, 500);
        applet.init();
        frame.setVisible(true);
    }
}