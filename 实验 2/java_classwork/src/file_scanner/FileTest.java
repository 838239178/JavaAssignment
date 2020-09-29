package file_scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTest {
    public final static String file0 = "src\\file_scanner\\Students.txt";
    public final static String file1 = "src\\file_scanner\\first_10.txt";

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        School school = new School();
        int n;
        String name;
        System.out.println("how many students do you want?");
        n = in.nextInt();
        System.out.println("who do you want to find?");
        in.nextLine();                                          //跳过多余换行符
        name = in.nextLine();

        try {
            //request 1.
            save(School.getRandomStu(n), file0);
            //request 2.
            school.setStudents(read(file0));
            school.countSource();
            save(school.getAllStu(), file0);
            //request 3.
            save(school.getExcellentStu(), file1);
            //request 4.
            String[] stuOfName = school.findStudent(name);
            for (String s : stuOfName) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void save(ArrayList<Student> students, String filePath) throws FileNotFoundException{
            PrintWriter fwrite = new PrintWriter(new File(filePath));
            fwrite.println("Name Math Java DS Average Total");
            students.forEach((Student s )->{
                fwrite.println(s.toString());
            });
            fwrite.close();
    }

    public static ArrayList<Student> read(String filePath) throws FileNotFoundException{
        Scanner fread = new Scanner(new File(filePath));
        ArrayList<Student> stus = new ArrayList<>();
        fread.nextLine(); //跳过第一行标题
        Student stu;
        while (fread.hasNextLine()){
            stu = new Student(fread.nextLine());
            stus.add(stu);
        }
        fread.close();
        return stus;
    }
}
