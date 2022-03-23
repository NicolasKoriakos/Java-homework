package com.company;

public class MediumBuilding extends Building{

    private int amountOfFloors;
    private boolean stairs;

    public MediumBuilding(int sizeInSquareMeters, int doors, String city, int amountOfFloors) {
        super(sizeInSquareMeters, doors, city);
        this.amountOfFloors = amountOfFloors;

        if (amountOfFloors > 1){
            this.stairs = true;
        } else {
            this.stairs = false;
        }
    }

    public int getAmountOfFloors() {
        return amountOfFloors;
    }

    public boolean getStairs() {
        return stairs;
    }
}
