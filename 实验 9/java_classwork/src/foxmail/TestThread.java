package foxmail;

public class TestThread {
    public static void main(String[] args) {
        Thread[] threads = new Thread[6];
        for (int i = 0; i < threads.length; i++) {
            if (i < 3) {
                threads[i] = new Thread(new ReceiveMailRunnable());
            } else {
                threads[i] = new Thread(new SendMailRunnable());
            }
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

        System.out.println("foxmail 任务结束");
    }
}
