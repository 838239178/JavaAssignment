package sum;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestSumWorker {
    public static void main(String[] args) {
        Result res = new Result();
        Thread[] threads = new Thread[10];
        int maxPart = 10000;
        int max = (int) 1e9;
        int min = 1;
        int times = max / (maxPart * threads.length);
        System.out.println("correct:" +((min+max)*(long)max)/2);
        try {
            int m = min;
            for (int i = 0; i < times; i++) {
                for (int j = 0; j < threads.length; j++) {
                    threads[j] = new Thread(new SumWorker(m, m + maxPart, res));
                    m = m + maxPart;
                    threads[j].start();
                }
                for (Thread thread : threads) {
                    thread.join();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("result :" + res.getSum());
        }
    }
}
