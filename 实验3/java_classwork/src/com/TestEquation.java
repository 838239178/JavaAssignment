package com;

import java.util.Scanner;

public class TestEquation {
    public static void main(String[] args) {
        int a, b, c;
        Scanner in = new Scanner(System.in);
        System.out.println("顺序输入方程ax2+bx+c=0的系数a,b,c:");
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        QuadraticEquation equ = new QuadraticEquation(a,b,c);
        int delta = equ.getDiscriminant();
        String res;
        if(delta < 0)
            res = "The equation has no roots";
        else if (delta > 0)
            res = equ.getRoot1() + " " + equ.getRoot2();
        else
            res = String.valueOf(equ.getRoot1());
        System.out.println(delta);
        System.out.println(res);
    }
}
