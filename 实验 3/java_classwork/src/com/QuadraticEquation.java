package com;

public class QuadraticEquation {
    private int a,b,c;

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getDiscriminant(){
        return b*b - 4*a*c;
    }

    public double getRoot1(){
        int delta = getDiscriminant();
        if(delta< 0) return 0;
        return (-b+Math.sqrt(delta))/(2.0*a);
    }

    public double getRoot2(){
        int delta = getDiscriminant();
        if(delta< 0) return 0;
        return (-b-Math.sqrt(delta))/(2.0*a);
    }

}
