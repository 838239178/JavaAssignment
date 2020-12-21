package sum;

import java.util.concurrent.Callable;

public class SumWorker implements Runnable {
    //[m,n)
    private final int m;
    private final int n;
    private final Result sum;

    SumWorker(int m, int n, Result sum) {
        this.m = m;
        this.n = n;
        this.sum = sum;
    }

    @Override
    public void run() {
        for(int i = m; i < n; i++){
            synchronized (sum){
                sum.add(i);
            }
        }
    }
}
