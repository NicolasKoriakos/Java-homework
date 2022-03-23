package com.company;

public class SkyscraperBuilding extends LargeBuilding{

    private int amountOfApartments;
    private double sizeOfApartments;

    public SkyscraperBuilding(int sizeInSquareMeters, int doors, String city, int amountOfFloors,
                              int amountOfElevators, boolean hasRooftop, int amountOfApartments, double sizeOfApartments) {
        super(sizeInSquareMeters, doors, city, amountOfFloors, amountOfElevators, hasRooftop);
        this.amountOfApartments = amountOfApartments;
        this.sizeOfApartments = sizeOfApartments;
    }

    public int getAmountOfApartments() {
        return amountOfApartments;
    }

    public double getSizeOfApartments() {
        return sizeOfApartments;
    }
}
