package com;

import java.util.Scanner;

public class TestLeapYear {
    public static void main(String[] args){
        //思考解答： 非静态方法需要实例化对象才能使用
        LeapYear lp = new LeapYear();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(lp.isLeapYear(n));
    }
}
