package io;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ioTest {
    public static final String file1 = "text/obj1.txt";
    public static final String file2 = "text/obj2.txt";
    public static final String file3 = "text/obj3.txt";

    public static Student readStudent(DataInputStream dis) throws IOException {
        String name = dis.readUTF();
        int id = dis.readInt();
        int age = dis.readInt();
        double grade = dis.readDouble();
        return new Student(name, id, age, grade);
    }

    public static void writeStudent(Student s, DataOutputStream dos) throws IOException {
        dos.writeUTF(s.getName());
        dos.writeInt(s.getId());
        dos.writeInt(s.getAge());
        dos.writeDouble(s.getGrade());
    }

    public static Student readStudent(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        return (Student) ois.readObject();
    }

    public static void writeStudent(Student s, ObjectOutputStream oos) throws IOException {
        oos.writeObject(s);
    }

    public static Student readStudent(Scanner s) {
        String[] para = s.nextLine().split(",");
        String name = para[0];
        int id = Integer.parseInt(para[1]);
        int age = Integer.parseInt(para[2]);
        double grade = Double.parseDouble(para[3]);
        return new Student(name, id, age, grade);
    }

    public static void writeStudent(Student s, PrintWriter pw) {
        pw.write(s.toString());
    }



    public static void method1() {
        System.out.println("test 1");
        Student stu = new Student("tom", 1, 16, 60.5);

        //TWR try-with-resources
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file1));
             DataInputStream dis = new DataInputStream(new FileInputStream(file1))){
            writeStudent(stu, dos);
            dos.flush();
            stu = readStudent(dis);
            System.out.println(stu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() {
        System.out.println("test 2");
        Student stu = new Student("tom", 1, 16, 60.5);

        try (PrintWriter fop = new PrintWriter(new FileOutputStream(file2));
             Scanner fis = new Scanner(new FileInputStream(file2))){
            writeStudent(stu, fop);
            fop.flush();
            stu = readStudent(fis);
            System.out.println(stu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method3() {
        System.out.println("test 3");
        Student stu = new Student("tom", 1, 16, 60.5);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file3));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file3))){
            writeStudent(stu, oos);
            oos.flush();
            stu = readStudent(ois);
            System.out.println(stu);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        method1();
        method2();
        method3();
    }
}
