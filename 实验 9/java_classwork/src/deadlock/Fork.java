package deadlock;

import java.util.Arrays;

public class Fork {
    private final boolean[] isForkUsed;

    public Fork(int n) {
        this.isForkUsed = new boolean[n];
        Arrays.fill(isForkUsed, false);
    }

    public void getForks(int id) {
        int leftFork = id;
        int rightFork = (id + 1) % isForkUsed.length;
        synchronized (isForkUsed) {
            //如果没有同时获得两资源则释放锁等待
            while (isForkUsed[leftFork] || isForkUsed[rightFork]) {
                try {
                    isForkUsed.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isForkUsed[leftFork] = true;
            isForkUsed[rightFork] = true;
        }

    }

    public void returnForks(int id) {
        int leftFork = id;
        int rightFork = (id + 1) % isForkUsed.length;
        synchronized (isForkUsed){
            isForkUsed[leftFork] = false;
            isForkUsed[rightFork] = false;
            isForkUsed.notifyAll();
        }
    }
}
