package com;

import java.util.Scanner;

public class TestMatrix {
    public static void main(String[] args) {
        int a,b;
        Scanner in = new Scanner(System.in);
        System.out.println("输入矩阵行宽:");
        a = in.nextInt();
        b = in.nextInt();
        Matrix mA = getRandomMatrix(a,b);
        Matrix mB = getRandomMatrix(a,b);
        System.out.println("矩阵A:");
        mA.display();
        System.out.println("矩阵B:");
        mB.display();
        System.out.println("矩阵A+B:");
        mA.add(mB).display();
        System.out.println("矩阵A-B:");
        mA.minus(mB).display();
        System.out.println("矩阵A*B:");
        mA.multiple(mB).display();
        System.out.println("矩阵AT:");
        mA.transposition().display();
        System.out.println("矩阵BT:");
        mB.transposition().display();
    }

    public static Matrix getRandomMatrix(int row, int col){
        Matrix res = new Matrix(row, col);
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                res.setElement(i,j,Math.random()*10);
            }
        }
        return res;
    }
}
