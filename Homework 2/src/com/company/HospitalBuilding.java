package com.company;

public class HospitalBuilding extends LargeBuilding{

    private int amountOfDoctorsOffices;
    private double sizeOfOffice; //in meters
    private boolean hasEmergencyRoom;

    public HospitalBuilding(int sizeInSquareMeters, int doors, String city,
                            int amountOfFloors, int amountOfElevators, boolean hasRooftop,
                            int amountOfDoctorsOffices, double sizeOfOffice, boolean hasEmergencyRoom) {
        super(sizeInSquareMeters, doors, city, amountOfFloors, amountOfElevators, hasRooftop);
        this.amountOfDoctorsOffices = amountOfDoctorsOffices;
        this.sizeOfOffice = sizeOfOffice;
        this.hasEmergencyRoom = hasEmergencyRoom;
    }

    public int getAmountOfDoctorsOffices() {
        return amountOfDoctorsOffices;
    }

    public double getSizeOfOffice() {
        return sizeOfOffice;
    }

    public boolean isHasEmergencyRoom() {
        return hasEmergencyRoom;
    }
}
