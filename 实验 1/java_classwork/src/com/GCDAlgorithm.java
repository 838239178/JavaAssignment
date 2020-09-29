package com;

import java.util.Scanner;

/**
 * @author 201921122044
 */
public class GCDAlgorithm {

    public static void main(String[] args){
        int m = 0;
        int n = 0;
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        System.out.println("not recursive: " + gcd(m,n));
        System.out.println("recursive: " + gcd_recursive(m,n));
    }

    private static int gcd(int m, int n){
        int r = 0;

        if(m<n){
            int temp = m;
            m = n;
            n = temp;
        }

        r = m%n;

        while(r > 0){
            m = n;
            n = r;
            r = m%n;
        }

        return n;
    }

    private static int gcd_recursive(int m, int n){

        if(m<n){
            int temp = m;
            m = n;
            n = temp;
        }

        if( m%n == 0 )
            return n;
        else
            return gcd_recursive(n, m%n);
    }
}
