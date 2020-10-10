package stu;

import org.jetbrains.annotations.NotNull;

public class Student implements Comparable<Student>{
    private String name;
    public Source src;

    public Student(){
        name = "";
        src = new Source();
    }

    public Student(String name, int math, int java, int ds){
        this.name = name;
        src = new Source(math,java,ds);
    }

    public Student(String name, int math, int java, int ds, int avg, int total){
        this.name = name;
        src = new Source(math,java,ds,avg,total);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", src=" + src +
                '}';
    }

    @Override
    public int compareTo(@NotNull Student other) {
        return -Integer.compare(src.getAvg(), other.src.getAvg());
    }
}

class Source{
    private int math, java, ds;
    private int avg, total;

    public Source(){
        math = java = ds = avg = total = 0;
    }

    public Source(int math, int java, int ds) {
        this.math = math;
        this.java = java;
        this.ds = ds;
        getTotal();
        getAvg();
    }

    public Source(int math, int java, int ds, int avg, int total) {
        this(math,java,ds);
        this.avg = avg;
        this.total = total;
    }

    public void setMath(int math) {
        this.math = math;
        getAvg();
    }

    public void setJava(int java) {
        this.java = java;
        getAvg();
    }

    public void setDs(int ds) {
        this.ds = ds;
        getAvg();
    }

    public int getAvg() {
        avg = getTotal()/3;
        return avg;
    }

    public int getTotal() {
        total = math+java+ds;
        return total;
    }

    @Override
    public String toString() {
        return "Source{" +
                "math=" + math +
                ", java=" + java +
                ", ds=" + ds +
                ", avg=" + avg +
                ", total=" + total +
                '}';
    }
}
