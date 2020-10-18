package stu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestStu {
    public final static String file0 = "src\\stu\\Students.txt";

    public static void main(String[] args){
        try {
            printSortedStudents(readStudentsFromFile(file0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Student[] readStudentsFromFile(String fileName) throws FileNotFoundException {
        Scanner fread = new Scanner(new File(fileName));
        ArrayList<Student> stus = new ArrayList<>();
        Student stu;

        while (fread.hasNextLine()){
            stu = new Student();
            String[] m = fread.nextLine().split(" ");
            stu.setName(m[0]);
            stu.src.setMath(Integer.parseInt(m[1]));
            stu.src.setJava(Integer.parseInt(m[2]));
            stu.src.setDs(Integer.parseInt(m[3]));
            stus.add(stu);
        }
        fread.close();

        Student[] stud = new Student[stus.size()];
        stus.toArray(stud);
       
        return stud;
    }

    public static void printSortedStudents(Student[] students){
        Arrays.sort(students);
        for(Student s : students){
            System.out.println(s.toString());
        }
    }
}
