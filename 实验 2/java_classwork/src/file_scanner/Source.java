package file_scanner;

public class Source{
    private int math, java, ds;
    private int average, total;
    Source(){
        math = java = ds = average = total = 0;
    }
    Source(String[] s){
        math = Integer.parseInt(s[1]);
        java = Integer.parseInt(s[2]);
        ds = Integer.parseInt(s[3]);
        average = Integer.parseInt(s[4]);
        total = Integer.parseInt(s[5]);
    }
    Source(int m, int j, int d){
        math = m;
        java = j;
        ds = d;
    }
    public int countAverage(){
        average = (math+java+ds)/3;
        return average;
    }
    public int countTotal(){
        total=math+java+ds;
        return total;
    }

    @Override
    public String toString(){
        return math+" "+java+" "+ds+" "+average+" "+total;
    }
}