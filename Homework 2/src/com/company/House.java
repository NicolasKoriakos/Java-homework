package com.company;

public class House extends SmallBuilding{

    private int amountOfRooms;
    private double averageRoomSize; // In meters

    public House(int sizeInSquareMeters, int doors, String city, int gardenLength, int amountOfRooms, double averageRoomSize) {
        super(sizeInSquareMeters, doors, city, gardenLength);
        this.amountOfRooms = amountOfRooms;
        this.averageRoomSize = averageRoomSize;
    }

    public int getAmountOfRooms() {
        return amountOfRooms;
    }

    public double getAverageRoomSize() {
        return averageRoomSize;
    }
}
