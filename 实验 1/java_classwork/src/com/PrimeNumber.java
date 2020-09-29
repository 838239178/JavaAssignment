package com;
import java.util.Scanner;

/**
 * @author 201921122044
 */
public class PrimeNumber {

    public static void main(String[] args){
        int n = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] primes = getPrimeNumbers(n);
        printPrimeNumbers(primes, n);

    }
    /**
     * 计算并找出小于n的所有素数
     * @param n 限制素数的大小
     * @return 包含小于n的素数的数组
     */
    public static int[] getPrimeNumbers(int n){
        int[] result = new int[n];
        boolean[] isPrime = new boolean[n+1];
        //初始化为默认都是素数
        for(int i = 0; i<isPrime.length; i++){
            isPrime[i] = true;
        }

        //筛法求素数
        for(int num = 2; num*num < n; num++){
            if(isPrime[num]){
                for(int mult = num*num; mult <= n; mult += num){
                    isPrime[mult] = false;
                }
            }
        }

        //ArrayList<Integer> res = new ArrayList<>();

        int index = 0;
        for(int i = 2; i<isPrime.length; i++){
            if(isPrime[i]){
                result[index++] = i;
            }
        }

        return result;
    }

    /**
     * 打印小于n的素数
     * @param primes 素数数组
     * @param n 限制素数的大小
     */
    public static void printPrimeNumbers(int[] primes, int n){
        System.out.print("The prime numbers are");
        for(int i : primes){
            if(i != 0)
                System.out.print(" " + i);
        }
    }

}
