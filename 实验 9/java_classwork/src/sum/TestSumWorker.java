package sum;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestSumWorker {
    public static void main(String[] args) {
        Result res = new Result();
        FutureTask<Long>[] tasks = new FutureTask[10];
        int maxPart = 10000;
        int max = (int) 1e9;
        int min = 1;
        int times = max / (maxPart * tasks.length);
        System.out.println("correct:" +((min+max)*(long)max)/2);

        long start = System.currentTimeMillis();

        try {
            int m = min;
            for (int i = 0; i < times; i++) {
                for (int j = 0; j < tasks.length; j++) {
                    tasks[j] = new FutureTask<>(new SumWorker(m, m + maxPart));
                    new Thread(tasks[j]).start();
                    m = m + maxPart;
                }
                for (FutureTask<Long> task : tasks) {
                    res.add(task.get());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("result :" + res.getSum());
            System.out.println("time:" + (System.currentTimeMillis()-start));
        }
    }
}
