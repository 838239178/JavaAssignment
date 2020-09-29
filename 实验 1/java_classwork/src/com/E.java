package com;

import java.util.Scanner;

public class E {

    public static final double DEV = 1e-6;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(valueOfE(n));
    }

    public static double valueOfE(int n){
        double p = 1;
        double res = 1;
        for(int i = 1; i<=n; i++) {
            p = p * i;
            res += 1 / p;
        }
        return res;
    }

}
