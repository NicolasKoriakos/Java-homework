package com.company;

public class Worker extends Human{

    private int yearsOfExperience;

    public Worker(boolean alive, String name, int age, int yearsOfExperience) {
        super(alive, name, age);
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getSeniority() {

        String seniority;

        if (this.yearsOfExperience < 2){
            seniority = "Jr";
        } else if (this.yearsOfExperience >=2 && this.yearsOfExperience < 5){
            seniority = "Ssr";
        } else if (this.yearsOfExperience >= 5){
            seniority = "Sr";
        } else {
            seniority = "Jr";
            this.yearsOfExperience = 0;
        }

        return seniority;
    }
}
