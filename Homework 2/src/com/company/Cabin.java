package com.company;

public class Cabin extends SmallBuilding{

    private boolean hasFireplace;

    public Cabin(int sizeInSquareMeters, int doors, String city, int gardenLength, boolean hasFireplace) {
        super(sizeInSquareMeters, doors, city, gardenLength);
        this.hasFireplace = hasFireplace;
    }

    public boolean getHasFireplace() {
        return hasFireplace;
    }
}
