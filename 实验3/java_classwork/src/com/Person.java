package com;

public class Person {
    private static int count = 0;

    private int id;
    private String name;
    private int age;
    private String sex;

    public Person(){
        name = "";
        age = 0;
        sex = "man";
        id = ++count;
    }

    public Person(String name, int age){
        this();
        this.name = name;
        this.age = age;
    }

    public Person(String name, String sex, int age){
        this(name, age);
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
