package io;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int id;
    private int age;
    private double grade;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public Student(String name, int id, int age, double grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + "," + id + "," + age + "," + grade;
    }
}
