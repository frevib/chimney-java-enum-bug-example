package com.eventlooopsoftware;

public class PersonJava {
    // private does't work when Java -> Scala case class
    // use enable bean getters, then it works
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonJava(String name) {
        this.name = name;
    }
}
