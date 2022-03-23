package com.company;

public class Building {

    private int sizeInSquareMeters;
    private int doors;
    private String city;

    public Building(int sizeInSquareMeters, int doors, String city){
        this.sizeInSquareMeters = sizeInSquareMeters;
        this.doors = doors;
        this.city = city;

    }

    public int getSizeInSquareMeters() {
        return sizeInSquareMeters;
    }

    public int getDoors() {
        return doors;
    }

    public String getCity() {
        return city;
    }
}
