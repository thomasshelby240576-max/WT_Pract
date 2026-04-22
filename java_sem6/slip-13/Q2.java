import java.util.Random;

class MyThread extends Thread {
    private String threadName;

    public MyThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        int sleepTime = random.nextInt(5000);

        System.out.println("Thread " + threadName + " is running.");
        try {
            System.out.println("Thread " + threadName + " is sleeping for " + sleepTime + " milliseconds.");
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " has been interrupted.");
        }
        System.out.println("Thread " + threadName + " has finished running.");
    }
}

public class Q2 {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("A");
        MyThread thread2 = new MyThread("B");
        MyThread thread3 = new MyThread("C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}