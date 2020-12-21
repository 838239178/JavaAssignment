package sum;

public class Result {
    private long sum;

    Result(){ sum=0; }

    public void add(long num) {
        sum += num;
    }

    public long getSum() {
        return sum;
    }
}
