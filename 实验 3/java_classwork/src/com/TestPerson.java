package com;

public class TestPerson {
    public static void main(String[] args){
        //1.
        //思考解答： private修饰的变量和犯法无法在其他类中访问
        Person p = new Person();
        p.setAge(18);
        p.setName("小红");
        p.setSex("woman");
        System.out.println(p.toString());
        //4.
        for(int i = 0; i<5; i++){
            p = new Person("小李" + i, "man", (int) (Math.random()*30+15));
            System.out.println(p.toString());
        }
    }

}
