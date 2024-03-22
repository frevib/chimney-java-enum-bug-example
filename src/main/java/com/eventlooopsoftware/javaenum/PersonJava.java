package com.eventlooopsoftware.javaenum;

public class PersonJava {
    public String getName() {
        return name;
    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
    public Integer getAge() {
        return age;
    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }


    public PersonJava(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public PersonJava(String name) {
        this.name = name;
    }

    public String name;
//    public Integer age;
}
