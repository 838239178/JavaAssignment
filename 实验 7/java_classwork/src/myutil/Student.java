package myutil;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private int grade;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int grade) {
        this.grade = grade;
    }

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return this.getGrade()-o.getGrade();
    }

    @Override
    public String toString() {
        return "Student{" + name + ',' + age + ',' + grade + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
