package com.company;

public class TeamLeader extends Worker{

    private int peopleUnderCharge; //Amount of people under his/her charge

    public TeamLeader(boolean alive, String name, int age, int yearsOfExperience, int peopleUnderCharge) {
        super(alive, name, age, yearsOfExperience);
        this.peopleUnderCharge = peopleUnderCharge;
    }

    public int getPeopleUnderCharge() {
        return peopleUnderCharge;
    }

    public double monthlySalary(){

        String seniority = getSeniority();
        double salaryPerHour = 14.0;
        double salaryModifier = 0;

        if (seniority=="Jr"){
            salaryModifier = 1;
        } else if (seniority=="Ssr"){ // increments salary based on experience
            salaryModifier=1.5;
        } else {
            salaryModifier=2.2;
        }

        salaryModifier += (peopleUnderCharge * 0.1);

        salaryPerHour *= salaryModifier;

        return (salaryPerHour*8) * 20; //(Salary per hours * daily hours) * work days in the month

    }
}
