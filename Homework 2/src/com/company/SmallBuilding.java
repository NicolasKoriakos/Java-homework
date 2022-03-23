package com.company;

public class SmallBuilding extends Building{

    private int gardenLength;

    public SmallBuilding(int sizeInSquareMeters, int doors, String city, int gardenLength) {
        super(sizeInSquareMeters, doors, city);
         this.gardenLength = gardenLength;
    }

    public int getGardenLength() {
        return gardenLength;
    }
}
