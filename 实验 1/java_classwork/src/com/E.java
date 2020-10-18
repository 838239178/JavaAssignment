package com;

import java.util.Scanner;

public class E {

    public static final double DEV = 1e-6;

    public static void main(String[] args){
        System.out.println(valueOfE());
    }

    public static double valueOfE(){
        double p = 1;
        double res = 1;
        for(int i = 1;; i++) {
            p = p * i;
            res += 1 / p;
            if(1/p < DEV) break;
        }
        return res;
    }

}
