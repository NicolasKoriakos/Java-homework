package com.company;

public class MuseumBuilding extends MediumBuilding{

    private int amountOfArtGalleries;
    private double sizeOfStorageRoom;
    private boolean hasSecurityRoom;
    private double averageSizeOfArtGalleries;

    public MuseumBuilding(int sizeInSquareMeters, int doors, String city, int amountOfFloors,
                          int amountOfArtGalleries, double sizeOfStorageRoom, boolean hasSecurityRoom,
                          double averageSizeOfArtGalleries) {
        super(sizeInSquareMeters, doors, city, amountOfFloors);
        this.amountOfArtGalleries = amountOfArtGalleries;
        this.sizeOfStorageRoom = sizeOfStorageRoom;
        this.hasSecurityRoom = hasSecurityRoom;
        this.averageSizeOfArtGalleries = averageSizeOfArtGalleries;
    }

    public int getAmountOfArtGalleries() {
        return amountOfArtGalleries;
    }

    public double getSizeOfStorageRoom() {
        return sizeOfStorageRoom;
    }

    public boolean isHasSecurityRoom() {
        return hasSecurityRoom;
    }

    public double getAverageSizeOfArtGalleries() {
        return averageSizeOfArtGalleries;
    }
}
