public class Q1 {

    public static void main(String[] args) {
        // Create three threads
        Thread thread1 = new Thread(new MyRunnable(), "One");
        Thread thread2 = new Thread(new MyRunnable(), "Two");
        Thread thread3 = new Thread(new MyRunnable(), "Three");

        // Set priorities for each thread
        thread1.setPriority(Thread.MIN_PRIORITY); // Set minimum priority
        thread2.setPriority(Thread.NORM_PRIORITY + 1); // Set priority slightly above normal
        thread3.setPriority(Thread.MAX_PRIORITY); // Set maximum priority

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            System.out.println("Thread: " + currentThread.getName() + ", Priority: " + currentThread.getPriority());
        }
    }
}
