package com.java.leetcode;

public class User {
    public static void main(String[] args) {
        System.out.println(Son.m);
    }
    private String name;
    private int id;
    private int age;

    public User() {

    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User {" +
                "name = " + name +
                ", id = " + id +
                ", age = " + age +
                "}";
    }
}

class Father {

    public Father() {
        System.out.println("father load");
    }

    static {
        System.out.println("father load");
    }
    static int m = 2;
}

class Son extends Father {
    static {
        System.out.println("Son loaded");

    }
    public Son() {
        System.out.println("son loaded");
    }

}