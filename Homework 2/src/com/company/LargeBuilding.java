package com.company;

public class LargeBuilding extends Building{

    private int amountOfFloors;
    private int amountOfElevators;
    private boolean hasRooftop;
    private String buildingName;

    public LargeBuilding(int sizeInSquareMeters, int doors, String city, int amountOfFloors, int amountOfElevators, boolean hasRooftop) {
        super(sizeInSquareMeters, doors, city);
        this.amountOfFloors = amountOfFloors;
        this.amountOfElevators = amountOfElevators;
        this.hasRooftop = hasRooftop;
    }

    public int getAmountOfFloors() {
        return amountOfFloors;
    }

    public int getAmountOfElevators() {
        return amountOfElevators;
    }

    public boolean getHasRooftop() {
        return hasRooftop;
    }
}
