package com.company;

public class EducationalBuilding extends MediumBuilding{

    private int amountOfClassrooms;
    private double classroomAverageSize;
    private boolean hasSportsRooms;

    public EducationalBuilding(int sizeInSquareMeters, int doors, String city, int amountOfFloors,
                               int amountOfClassrooms, double classroomAverageSize, boolean hasSportsRooms) {
        super(sizeInSquareMeters, doors, city, amountOfFloors);
        this.amountOfClassrooms = amountOfClassrooms;
        this.classroomAverageSize = classroomAverageSize;
        this.hasSportsRooms = hasSportsRooms;
    }

    public int getAmountOfClassrooms() {
        return amountOfClassrooms;
    }

    public double getClassroomAverageSize() {
        return classroomAverageSize;
    }

    public boolean getHasSportsRooms() {
        return hasSportsRooms;
    }
}
