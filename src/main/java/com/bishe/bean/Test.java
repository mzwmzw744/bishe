package com.bishe.bean;

public class Test {
    public int id;
    public String name;
    public int age;

    public Test(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Test() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
