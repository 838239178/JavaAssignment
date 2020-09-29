package com;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RandomTest {

    public static void main(String[] args){
        int n = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        //request 1. print inside
        countRandomNum(n);
        //request 2. print inside
        countRandomChar(n);
        //request 3. print inside
        try {
            countCharOnTxT("src\\com\\Object.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void countCharOnTxT(String filePath) throws FileNotFoundException {
        Scanner txtIn = new Scanner(new File(filePath));
        HashMap<Character, Integer> charMap = new HashMap<>();
        //初始化哈希表
        for(char c = 'a'; c<='z'; c++){
            charMap.put(c, 0);
        }

        int lineCode = 1;
        int totalChar = 0;
        while (txtIn.hasNextLine()){
            String line = txtIn.nextLine();
            for(int i = 0; i<line.length(); i++){
                char c = line.charAt(i);
                if(c >= 'a' && c <= 'z') {
                    int value = charMap.remove(c);
                    charMap.put(c, value + 1);
                    totalChar++;
                }
            }
        }
        txtIn.close();

        System.out.println("3.");
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
            String res = String.format("%.2f",(float)entry.getValue()/totalChar * 100.0);
            System.out.println(entry.getKey() + ":" + res + "%");
        }
    }

    public static void countRandomNum(int n){
        int[] nums = new int[n];
        float bigCnt = 0;

        for(int i = 0; i<nums.length; i++) {
            nums[i] = getRandomNum(2000, 3000);
        }
        for(int i : nums) if(i > 2500) bigCnt++;

        float percent = bigCnt/n * 100;

        System.out.println("1.");
        System.out.println("number greater than 2500: " + percent + "%");
        System.out.println("number less than or equal to 2500: " + (100-percent) + "%");
    }

    public static void countRandomChar(int n){
        HashMap<Character, Integer> charMap = new HashMap<>();
        //初始化哈希表
        for(char c = 'a'; c<='z'; c++){
            charMap.put(c, 0);
        }

        for(int i = 0; i<n; i++){
            char randomChar = getRandomChar('a','z');
            int value = charMap.remove(randomChar);
            charMap.put(randomChar, value+1);
        }

        System.out.println("2.");
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
            String res = String.format("%.2f",(float)entry.getValue()/n * 100.0);
            System.out.println(entry.getKey() + ":" + res + "%");
        }
    }

    /**
     * 返回给定范围内的随机字符
     * @param min 下限
     * @param max 上限
     * @return  返回char类型
     */
    public static char getRandomChar(char min, char max){
        if(min>max)
            return 0;
        return (char) (Math.random()*(max-min+1)+min);
    }

    /**
     * 返回给定范围内的随机数
     * @param min 下限
     * @param max 上限
     * @return 返回int类型
     */
    public static int getRandomNum(int min, int max){
        if(min>max)
            return 0;
        return (int) (Math.random()*(max-min+1)+min);
    }
}
