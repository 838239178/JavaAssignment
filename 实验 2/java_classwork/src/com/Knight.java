package com;

import java.util.LinkedList;
import java.util.Scanner;



public class Knight {
    private static int ansNum = 0;
    private static int count = 0;
    private static int[][] board;
    private static final int[] dirX = {1,2,2,1,-1,-2,-2,-1};
    private static final int[] dirY = {2,1,-1,-2,-2,-1,1,2};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("输入棋盘大小：");
        int n = in.nextInt();
        System.out.println("输入所需解的个数：");
        ansNum = in.nextInt();
        board = new int[n][n];
        //travel(1,0,0);
        travelf(new VecInt(0,0));
    }

    public static void printPath(){
        System.out.println("success " + count);
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        if(count == ansNum) System.exit(1);
    }



    /**
     * 堆栈迭代法求解
     * @param v1 起始点坐标
     * error 1. stack中的对象应该是一份拷贝而不是引用  solution: 引用->new
     * error 2. 无法明确再次访问的点应从哪个方向开始，即无法排除错误方向  solution: use another stack
     */
    public static void travelf(VecInt v1){
        int step = 1;
        boolean flag;
        VecInt v2 = new VecInt(0,0);
        LinkedList<VecInt> stack = new LinkedList<>();
        LinkedList<Integer> dirStack = new LinkedList<>();

        stack.push(new VecInt(v1));
        dirStack.push(0);

        while (!stack.isEmpty()){
            flag = true;
            v1.set(stack.peek());
            board[v1.getY()][v1.getX()] = step;
            if(step == board.length*board.length){
                count++;
                printPath();
            }
            else{
                for(int i = dirStack.poll(); i<dirX.length; i++){
                    v2.set(v1);
                    v2.sub(dirX[i],dirY[i]);
                    if(judge(v2.getY(),v2.getX())){
                        step++;
                        flag = false;
                        stack.push(new VecInt(v2));
                        dirStack.push(i+1);     //当前点遍历到的方向
                        dirStack.push(0);       //下一轮访问的点从0开始
                        break;
                    }
                }
            }
            if(flag && !stack.isEmpty()){
                step--;
                v2 = stack.poll();
                board[v2.getY()][v2.getX()] = 0;
            }
        }
    }

    /**
     * 递归法求解
     * @param step 步数，当达到n*n时得到一组解
     * @param y 起始点y坐标
     * @param x 起始点x坐标
     */
    public static void travel(int step, int y, int x){
        board[y][x] = step;
        if(step == board.length*board.length){
            count++;
            printPath();
            return;
        }
        int nextX, nextY;
        for(int i = 0; i<8; i++){
            nextX = x + dirX[i];
            nextY = y + dirY[i];
            if(judge(nextY,nextX)){
                travel(step+1, nextY,nextX);
                board[nextY][nextX] = 0;
            }
        }
    }

    public static boolean judge(int y, int x){
        return x >= 0 && x < board.length
                && y >= 0 && y < board.length
                && board[y][x] == 0;
    }


}
