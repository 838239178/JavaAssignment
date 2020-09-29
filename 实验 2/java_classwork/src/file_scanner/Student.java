package file_scanner;

import org.jetbrains.annotations.NotNull;

public class Student implements Comparable<Student>{
    private String name;
    public Source src;

    Student(){
        name = "张三";
        src = new Source();
    }
    Student(String line){
        String[] m = line.split(" ");
        name = m[0];
        src = new Source(m);
    }
    Student(int n, int m, int j, int d){
        name = "张三" + n;
        src = new Source(m,j,d);
    }

    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }

    @Override
    public String toString(){
        return name+" "+src.toString();
    }


    @Override
    public int compareTo(@NotNull Student other) {
        return -Integer.compare(src.countAverage(), other.src.countAverage());
    }
}
