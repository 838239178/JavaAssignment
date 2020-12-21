package deadlock;

public class TestLock {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        Fork fork = new Fork(5);
        for (int i = 0; i < 5; i++) {
            threads[i] = new Philosopher(i, fork);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
