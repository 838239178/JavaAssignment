package sum;

import java.util.concurrent.Callable;

public class SumWorker implements Callable<Long> {
    //[m,n)
    private final int m;
    private final int n;
    private final Result sum;

    SumWorker(int m, int n) {
        this.m = m;
        this.n = n;
        this.sum = new Result();
    }

    @Override
    public Long call() {
        for (int i = m; i < n; i++) {
            sum.add(i);
        }
        return sum.getSum();
    }
}
