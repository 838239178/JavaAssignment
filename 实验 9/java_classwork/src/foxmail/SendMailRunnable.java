package foxmail;

import java.util.Random;

public class SendMailRunnable implements Runnable {
    Random random;

    SendMailRunnable() {
        random = new Random();
    }

    @Override
    public void run() {
        int runTimes = random.nextInt(10) + 10;
        int sleepTime = random.nextInt(1000) + 1000;
        try {
            for (int i = 0; i < runTimes; i++) {
                System.out.println("i am sending emails");
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " exit");
        }
    }
}
