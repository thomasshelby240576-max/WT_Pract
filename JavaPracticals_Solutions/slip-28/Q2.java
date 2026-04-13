public class Q2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(), "One");
        Thread thread2 = new Thread(new MyRunnable(), "Two");

        thread1.start();
        thread2.start();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread " + threadName + " is executing.");
        }
    }
}
