package com.company;

public class Human {

    private boolean alive;
    private String name;
    private int age;

    public Human(boolean alive, String name, int age) {
        this.alive = alive;
        this.name = name;
        this.age = age;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
