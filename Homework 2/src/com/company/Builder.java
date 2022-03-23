package com.company;

public class Builder extends Worker{

    private boolean machineryExpert;
    private boolean materialExpert;

    public Builder(boolean alive, String name, int age, int yearsOfExperience, boolean machineryExpert, boolean materialExpert) {
        super(alive, name, age, yearsOfExperience);
        this.machineryExpert = machineryExpert;
        this.materialExpert = materialExpert;
    }

    public boolean isMachineryExpert() {
        return machineryExpert;
    }

    public boolean isMaterialExpert() {
        return materialExpert;
    }

    public double monthlySalary(){

        String seniority = getSeniority();
        double salaryPerHour = 12.50;
        double salaryModifier = 0;

        if (seniority=="Jr"){
            salaryModifier = 1;
        } else if (seniority=="Ssr"){ // increments salary based on experience
            salaryModifier=1.5;
        } else {
            salaryModifier=2.2;
        }

        if (machineryExpert || materialExpert){
            salaryModifier += 0.2;  // Increments salary based on expertise
        }

        salaryPerHour *= salaryModifier;

        return (salaryPerHour*8) * 20; //(Salary per hours * daily hours) * work days in the month

    }
}
