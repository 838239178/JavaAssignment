package com;

import java.util.Arrays;
import java.util.Scanner;

/**
 * test data:
 * 5
 * 350102199902131018
 * 320102200002131018
 * 350102199902141018
 * 350102200002131018
 * 350102199901141018
 */

public class StringTest {

    public static void main(String[] args){
        //request 1.
        System.out.println("1.");
        String id = "350102199902131018";
        String result = getBirthDate(id);
        System.out.println(result);
        //request 2.
        System.out.println("2.");
        Scanner in = new Scanner(System.in);
        int n = 0;
        n = in.nextInt();
        String[] ids = new String[n];
        in.nextLine();                                                  //读取多余的‘\n’
        for(int i = 0; i<n; i++) ids[i] = in.nextLine();
        printBirthDate(ids);
        //request 3.
        System.out.println("3.");
        String[] sortedIds = sortIdByBirth(ids);
        for (String s : sortedIds) System.out.println(s);
    }

    public static String getBirthDate(String id){
        String birthDay = "";
        birthDay += id.substring(6, 6+4);
        birthDay += '-';
        birthDay += id.substring(10,10+2);
        birthDay += '-';
        birthDay += id.substring(12,12+2);

        return birthDay;
    }

    public static void printBirthDate(String[] ids){
        String[] days = new String[ids.length];
        int index = 0;
        for (String id : ids){
            days[index++] = getBirthDate(id);
        }
        Arrays.sort(days);
        for(String day : days)
            System.out.println(day);
    }

    public static String[] sortIdByBirth(String[] ids){
        Arrays.sort(ids,(String s1, String s2)->{
            String birth1 = getBirthDate(s1);
            String birth2 = getBirthDate(s2);
            return birth1.compareTo(birth2);
        });
        return ids;
    }
}
