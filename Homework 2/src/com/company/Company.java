package com.company;

import java.util.Scanner;

public class Company {

    public static void startMenu() {
        int option;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hello, Welcome to de building simulation program...\n" +
                    "Here we are going to calculate how much will it cost to make a building based on the size of it and the amount of people we are hiring. \n" +
                    "First let's select the size of the building \n\n" +
                    "1 = Small Building \n" +
                    "2 = Medium Building \n" +
                    "3 = Large building \n" +
                    "Choose one option(1,2,3): ");
            option = scanner.nextInt();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        } while (option < 1 || option > 3);

        createBuilding(option);

    }

    public static void createBuilding(int option) {

        if (option == 1) {
            System.out.println("\n\nYou chose to create a small building...");
            System.out.println("\n\n");
        } else if (option == 2) {
            System.out.println("\n\nYou chose to create a medium building...");
            System.out.println("\n\n");
        } else if (option == 3) {
            System.out.println("\n\nYou chose to create a large building...");
            System.out.println("\n\n");
        } else {
            System.out.println("\n\nWrong option, please select a valid option.");
            System.out.println("Going back tu start menu.");
            System.out.println("\n\n");
            startMenu();
        }


        Scanner scanner = new Scanner(System.in);

        int option2;
        do {
            System.out.println("In order to create your building we need to know where do you want it and \n" +
                    "the size of the surface that you want to cover in square meters");
            System.out.println("First let's select the city \n\n" +
                    "1 = New York - 1300 U$D(price per square meter in this city)\n" +
                    "2 = Minsk - 800 U$D(price per square meter in this city) \n" +
                    "3 = Buenos Aires - 450 U$D(price per square meter in this city) \n" +
                    "Choose one option(1,2,3): ");
            option2 = scanner.nextInt();

            if (option2 != 1 && option2 != 2 && option2 != 3) {
                System.out.println("\n\n\n\n\n\n\n\n\nPlease select a valid option (1,2,3)\n");
            }
        } while (option2 != 1 && option2 != 2 && option2 != 3);
        System.out.println("\n\n");

        // Set the values chosen by de user
        String city;
        int pricePerSquareMeter;

        if (option2 == 1) {
            city = "New York";
            pricePerSquareMeter = 1300;
        } else if (option2 == 2) {
            city = "Minsk";
            pricePerSquareMeter = 800;
        } else {
            city = "Buenos Aires";
            pricePerSquareMeter = 450;
        }

        if (option == 1) {
            createSmallBuilding(city, pricePerSquareMeter);
        } else if (option == 2) {
            createMediumBuilding(city, pricePerSquareMeter);
        } else {
            createLargeBuilding(city, pricePerSquareMeter);
        }

    }

    // Small Building Methods

    private static void createSmallBuilding(String city, int price) {
        System.out.println("Great, so you chose a small building in " + city);
        System.out.println("Now is time to chose the size of the surface that you want to cover." +
                "\nSmall buildings have a minimum size of 50 square meters and a maximum of 500 square meters \n\n");

        Scanner scanner = new Scanner(System.in);
        int size;

        do {
            System.out.println("Please choose the size of your building (remember that it must be between 50 and 500 meters)");
            size = scanner.nextInt();
        } while (size < 50 || size > 500);

        System.out.println("\n\n");
        System.out.println("Now that we know your city and the size of your building" +
                "\nis time to choose which kind of building we are making.\n" +
                "You choose small building so you have this options: House and Cabin \n" +
                "Houses need at least 8 builders so they are more expensive then Cabins. \n" +
                "The amount of builders that you have impacts directly on the costs and length of the project.\n" +
                "For example: If you have 1 builder you may take 1 year to make a cabin but if you have 2 builders it will take half the time.\n" +
                "Houses need at least 8 builders and take 1 year to make with that amount of builders, cabins need 1 builder and take 1 year to make.\n\n");

        int option;

        do {
            System.out.println("Choose your building:\n" +
                    "1 - House\n" +
                    "2 - Cabin");
            option = scanner.nextInt();
        } while (option != 1 && option != 2);

        if (option == 1) {
            System.out.println("You chose to build a house");
            System.out.println("Whats the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                    "but it also means that is going to cost more.\n");
            System.out.println("Team Size(each team has 8 builders): ");
            int teamSize = scanner.nextInt();
            System.out.println("\n\n");
            createHouse(price, size, teamSize, city);
        } else {
            System.out.println("You chose to build a cabin");
            System.out.println("Whats the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                    "but it also means that is going to cost more.\n");
            System.out.println("Team Size(each team has 1 builder): ");
            int teamSize = scanner.nextInt();
            System.out.println("\n\n");
            createCabin(price, size, teamSize, city);
        }


    }

    private static void createHouse(int pricePerSquareMeter, int size, int teamSize, String city) {

        int buildersCost = 0;
        int amountOfBuilders = 8 * teamSize; //Each team has at least 8 builders
        double constructionDuration = 365;
        constructionDuration /= teamSize;

        for (int i = 0; i != amountOfBuilders; i++) {
            Builder builder = new Builder(true, "Anonymous", 18, 1, false, false);
            buildersCost += builder.monthlySalary();
        }

        House house = new House(size, 8, city, (size / 2), 5, (size / 5.0));
        double constructionCost = size * pricePerSquareMeter;

        double totalCost = constructionCost + buildersCost;

        System.out.println("The total of the construction cost of this building is: " + totalCost + " US Dollars.");
        System.out.println("The amount of time that is needed to end this building is: " + constructionDuration + " days.");
        System.out.println("Your house was built on: " + house.getCity());
        System.out.println("Your house has " + house.getAmountOfRooms() + " rooms with an average size of " + house.getAverageRoomSize() + " Square meters");
        System.out.println("Your house size is: " + house.getSizeInSquareMeters() + " Square meters");
        System.out.println("Your house garden size is: " + house.getGardenLength() + " Square meters");

    }

    private static void createCabin(int pricePerSquareMeter, int size, int teamSize, String city) {
        int buildersCost = 0;
        double constructionDuration = 365;
        constructionDuration /= teamSize;
        // the amount of builders and team size are the same value in this class. We don't need a amountOfBuilders variable
        for (int i = 0; i != teamSize; i++) {
            Builder builder = new Builder(true, "Anonymous", 18, 1, false, false);
            buildersCost += builder.monthlySalary();
        }

        Cabin cabin = new Cabin(size, 1, city, (size / 2), true);
        double constructionCost = size * pricePerSquareMeter;
        double totalCost = constructionCost + buildersCost;

        if (cabin.getHasFireplace()) totalCost += 2500;

        System.out.println("The total of the construction cost of this building is: " + totalCost + " US Dollars.");
        System.out.println("The amount of time that is needed to end this building is: " + constructionDuration + " days.");
        System.out.println("You cabin was built on: " + cabin.getCity());
        System.out.println("Your cabin size is: " + cabin.getSizeInSquareMeters() + " Square meters");
        if (cabin.getHasFireplace()) System.out.println("You cabin has a fireplace.");
    }

    // Medium Building Methods
    private static void createMediumBuilding(String city, int price) {
        System.out.println("Great, so you chose a Medium building in " + city);
        System.out.println("Now is time to chose the size of the surface that you want to cover." +
                "\nMedium buildings have a minimum size of 501 square meters and a maximum of 2000 square meters \n\n");


        Scanner scanner = new Scanner(System.in);
        int size;

        do {
            System.out.println("Please choose the size of your building (remember that it must be between 501 and 2000 meters)");
            size = scanner.nextInt();
        } while (size < 501 || size > 2000);

        System.out.println("\n\n");
        System.out.println("Now that we know your city and the size of your building" +
                "\nis time to choose which kind of building we are making.\n" +
                "You choose medium building so you have this options: \n Educational building and Museum \n\n" +
                "Educational Buildings need at least 50 builders so they are more expensive then Museums that only need 20 builders. \n" +
                "The amount of builders that you have impacts directly on the costs and length of the project.\n" +
                "For example: If you have 50 builder you may take 1 year to make a Educational Building but if you have 100 builders it will take half the time.\n" +
                "Each building team has 8 builders, for every 10 builders you have you will need a team Leader, so please have this in mind before you hire them.\n");

        int option;
        int teamSize;

        do {
            System.out.println("Choose your building:\n" +
                    "1 - Educational building\n" +
                    "2 - Museum");
            option = scanner.nextInt();
            System.out.println("\n");
        } while (option != 1 && option != 2);

        if (option == 1) {
            do {
                System.out.println("You chose to build an educational Building");
                System.out.println("Remember that educational buildings need at least 40 builders");
                System.out.println("What's the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                        "but it also means that is going to cost more.\n");
                System.out.println("Team Size(each team has 8 builders): ");
                teamSize = scanner.nextInt();
                System.out.println("\n\n");
            } while (teamSize < 5);
            createEducationalBuilding(price, size, teamSize, city);
        } else {
            do {
                System.out.println("You chose to build a Museum");
                System.out.println("Remember that museums need at least 20 builders");
                System.out.println("What's the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                        "but it also means that is going to cost more.\n");
                System.out.println("Team Size(each team has 8 builders): ");
                teamSize = scanner.nextInt();
                System.out.println("\n\n");
            } while (teamSize < 3);
            createMuseum(price, size, teamSize, city);
        }
    }

    private static void createEducationalBuilding(int pricePerSquareMeter, int size, int teamSize, String city) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Before we create your new Educational building we need to know how many floors and how many classrooms do you want in it" +
                "\neach floor will increment it's value");
        System.out.println("Number of floors: ");
        int floors = scanner.nextInt();
        System.out.println("Number of classrooms: ");
        int classrooms = scanner.nextInt();

        int buildersCost = 0;
        int amountOfBuilders = 8 * teamSize; //Each team has at least 8 builders
        double constructionDuration = 365;
        constructionDuration /= (amountOfBuilders / 40.0);
        int countOfBuilders = 0;

        for (int i = 0; i != amountOfBuilders; i++) {
            Builder builder = new Builder(true, "Anonymous", 21, 3, true, false);
            buildersCost += builder.monthlySalary();
            countOfBuilders++;

            if (countOfBuilders == 10) {
                TeamLeader teamLeader = new TeamLeader(true, "Anonymous", 30, 3, 10);
                buildersCost += teamLeader.monthlySalary();
                countOfBuilders = 0;
            }

        }

        EducationalBuilding educationalBuilding = new EducationalBuilding(size, 20, city, floors, classrooms, ((size * floors) / classrooms), true);

        double totalCost;
        double constructionCost = size * pricePerSquareMeter;

        if (educationalBuilding.getHasSportsRooms()) {
            totalCost = ((constructionCost + buildersCost) * (floors / 2)) + 100000;
        } else {
            totalCost = (constructionCost + buildersCost) * (floors / 2);
        }

        System.out.println("The total of the construction cost of this building is: " + totalCost + " US Dollars.");
        System.out.println("The amount of time that is needed to end this building is: " + constructionDuration + " days.");
        System.out.println("Your Educational Building was built on: " + educationalBuilding.getCity());
        System.out.println("Your Educational Building has " + educationalBuilding.getAmountOfClassrooms() + " rooms with an average size of "
                + educationalBuilding.getClassroomAverageSize() + " Square meters");
        System.out.println("Your Educational Building size is: " + educationalBuilding.getSizeInSquareMeters() + " Square meters");

        if (educationalBuilding.getHasSportsRooms()) {
            System.out.println("Your Educational Building has a Sports Room");
        } else {
            System.out.println("Your Educational Building doesn't have an Sports room");
        }
    }

    private static void createMuseum(int pricePerSquareMeter, int size, int teamSize, String city) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Before we create your new Museum we need to know how many floors and how many galleries do you want in it" +
                "\neach floor will increment it's value");
        System.out.println("Number of floors: ");
        int floors = scanner.nextInt();
        System.out.println("Number of galleries: ");
        int gallery = scanner.nextInt();

        int buildersCost = 0;
        int amountOfBuilders = 8 * teamSize; //Each team has at least 8 builders
        double constructionDuration = 365;
        constructionDuration /= (amountOfBuilders / 40.0);
        int countOfBuilders = 0;

        for (int i = 0; i != amountOfBuilders; i++) {
            Builder builder = new Builder(true, "Anonymous", 21, 3, true, false);
            buildersCost += builder.monthlySalary();
            countOfBuilders++;

            if (countOfBuilders == 10) {
                TeamLeader teamLeader = new TeamLeader(true, "Anonymous", 30, 3, 10);
                buildersCost += teamLeader.monthlySalary();
                countOfBuilders = 0;
            }
        }

        MuseumBuilding museum = new MuseumBuilding(size, 50, city, floors, gallery, (size / 10.0), true, (((size / 10.0)) * 9) / gallery);

        int totalCost;
        int constructionCost = size * pricePerSquareMeter;

        if (museum.isHasSecurityRoom()) {
            totalCost = ((constructionCost + buildersCost) * (floors / 2)) + 100000;
        } else {
            totalCost = (constructionCost + buildersCost) * (floors / 2);
        }

        System.out.println("The total of the construction cost of this building is: " + totalCost + " US Dollars.");
        System.out.println("The amount of time that is needed to end this building is: " + constructionDuration + " days.");
        System.out.println("Your Museum Building was built on: " + museum.getCity());
        System.out.println("Your Museum Building has " + museum.getAmountOfArtGalleries() + " gallery rooms with an average size of "
                + museum.getAverageSizeOfArtGalleries() + " Square meters");
        System.out.println("Your Museum Building size is: " + museum.getSizeInSquareMeters() + " Square meters");
        System.out.println("The size of you Museum storage room is: " + museum.getSizeOfStorageRoom());

        if (museum.isHasSecurityRoom()) {
            System.out.println("Your museum has a Security room");
        } else {
            System.out.println("Your museum doesn't have a Security room.");
        }
    }

    // Large Building Methods
    private static void createLargeBuilding(String city, int price) {
        System.out.println("Great, so you chose a Large building in " + city);
        System.out.println("Now is time to chose the size of the surface that you want to cover." +
                "\nLarge buildings have a minimum size of 2001 square meters and a maximum of 10000 square meters \n\n");


        Scanner scanner = new Scanner(System.in);
        int size;

        do {
            System.out.println("Please choose the size of your building (remember that it must be between 2001 and 10000 meters)");
            size = scanner.nextInt();
        } while (size < 2001 || size > 10000);

        System.out.println("\n\n");
        System.out.println("Now that we know your city and the size of your building" +
                "\nis time to choose which kind of building we are making.\n" +
                "You choose Large building so you have this options: \n  Skyscraper and Hospital building.\n\n" +
                "Skyscrapers need at least 150 builders so they are more expensive then Hospitals that only need 100 builders. \n" +
                "The amount of builders that you have impacts directly on the costs and length of the project.\n" +
                "For example: If you have 150 builder you may take 1 year to make a Skyscraper but if you have 300 builders it will take half the time.\n" +
                "Each building team has 8 builders, for every 10 builders you have you will need a team Leader, so please have this in mind before you hire them.\n");

        int option;
        int teamSize;

        do {
            System.out.println("Choose your building:\n" +
                    "1 - Skyscraper\n" +
                    "2 - Hospital");
            option = scanner.nextInt();
            System.out.println("\n");
        } while (option != 1 && option != 2);

        if (option == 1) {
            do {
                System.out.println("You chose to build a Skyscraper");
                System.out.println("Remember that Skyscrapers need at least 150 builders(19 teams)");
                System.out.println("What's the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                        "but it also means that is going to cost more.\n");
                System.out.println("Team Size(each team has 8 builders): ");
                teamSize = scanner.nextInt();
                System.out.println("\n\n");
            } while (teamSize < 19);
            createSkyscraper(price, size, teamSize, city);

        } else {
            do {
                System.out.println("You chose to build a Hospital");
                System.out.println("Remember that Hospitals need at least 100 builders(13 teams)");
                System.out.println("What's the teamSize that you desire? Having a larger team means that the building will be built sooner \n" +
                        "but it also means that is going to cost more.\n");
                System.out.println("Team Size(each team has 8 builders): ");
                teamSize = scanner.nextInt();
                System.out.println("\n\n");
            } while (teamSize < 13);
            createHospital(price, size, teamSize, city);
        }
    }

    private static void createSkyscraper(int pricePerSquareMeter, int size, int teamSize, String city) {

        int floors;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Before we create your new Skyscraper building we need to know how many floors and how many apartments do you want in it" +
                    "\neach floor will increment it's value" +
                    "\nSkyscrapers have a minimum of 10 floors and a maximum of 50");
            System.out.println("Number of floors: ");
            floors = scanner.nextInt();
        } while (floors > 50 || floors < 10);

        System.out.println("Number of apartments: ");
        int apartments = scanner.nextInt();

        int elevator;

        do {
            System.out.println("How many elevators do you want for the Skyscraper?(the minimum is 1 and maximum 10)\n" +
                    "Each elevator ads 10.000 usd to the final cost of the Skyscraper" +
                    "Number of elevators:");
            elevator = scanner.nextInt();
        } while (elevator < 1 || elevator > 10);

        int buildersCost = 0;
        int amountOfBuilders = 8 * teamSize; //Each team has at least 8 builders
        double constructionDuration = 365;
        constructionDuration /= (amountOfBuilders / 150.0);
        int countOfBuilders = 0;

        for (int i = 0; i != amountOfBuilders; i++) {

            Builder builder = new Builder(true, "Anonymous", 27, 6, true, true);
            buildersCost += builder.monthlySalary();
            countOfBuilders++;

            if (countOfBuilders == 10) {
                TeamLeader teamLeader = new TeamLeader(true, "Anonymous", 38, 6, 10);
                buildersCost += teamLeader.monthlySalary();
                countOfBuilders = 0;
            }

        }

        SkyscraperBuilding skyscraper = new SkyscraperBuilding(size,500,city,floors,elevator,true,apartments,(size/apartments));

        int totalCost;
        int constructionCost = size * pricePerSquareMeter;

        if (skyscraper.getHasRooftop()) {
            totalCost = (skyscraper.getAmountOfElevators() * 10000) + ((constructionCost + buildersCost) * (floors / 2)) + 100000;
        } else {
            totalCost = (skyscraper.getAmountOfElevators() * 10000) + ((constructionCost + buildersCost) * (floors / 2));
        }

        System.out.println("The total of the construction cost of this building is: " + totalCost + " US Dollars.");
        System.out.println("The amount of time that is needed to end this building is: " + constructionDuration + " days.");
        System.out.println("Your Skyscraper was built on: " + skyscraper.getCity());
        System.out.println("Your Skyscraper has " + skyscraper.getAmountOfApartments() + " rooms with an average size of "
                + skyscraper.getSizeOfApartments() + " Square meters");
        System.out.println("Your Skyscraper size is: " + skyscraper.getSizeInSquareMeters() + " Square meters");
        System.out.println("You Skyscraper has " + skyscraper.getAmountOfElevators() + " elevators");

        if (skyscraper.getHasRooftop()) {
            System.out.println("Your Skyscraper Building has a rooftop");
        } else {
            System.out.println("Your Skyscraper Building doesn't have a rooftop");
        }

    }

    private static void createHospital(int pricePerSquareMeter, int size, int teamSize, String city){

        int floors;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Before we create your new Hospital building we need to know how many floors and how many Doctor's Office do you want in it" +
                    "\neach floor will increment it's value" +
                    "\nHospitals have a minimum of 4 floors and a maximum of 10");
            System.out.println("Number of floors: ");
            floors = scanner.nextInt();
        } while (floors > 10 || floors < 4);

        System.out.println("Number of Doctor's Office: ");
        int doctorOffice = scanner.nextInt();

        int elevator;

        do {
            System.out.println("How many elevators do you want for the Hospital?(the minimum is 1 and maximum 5)\n" +
                    "Each elevator ads 10.000 usd to the final cost of the Hospital" +
                    "Number of elevators:");
            elevator = scanner.nextInt();
        } while (elevator < 1 || elevator > 5);

        int buildersCost = 0;
        int amountOfBuilders = 8 * teamSize; //Each team has at least 8 builders
        double constructionDuration = 365;
        constructionDuration /= (amountOfBuilders / 150.0);
        int countOfBuilders = 0;

        for (int i = 0; i != amountOfBuilders; i++) {

            Builder builder = new Builder(true, "Anonymous", 27, 6, true, true);
            buildersCost += builder.monthlySalary();
            countOfBuilders++;

            if (countOfBuilders == 10) {
                TeamLeader teamLeader = new TeamLeader(true, "Anonymous", 38, 6, 10);
                buildersCost += teamLeader.monthlySalary();
                countOfBuilders = 0;
            }

        }

        HospitalBuilding hospital = new HospitalBuilding(size, 150,city,floors,elevator,true,doctorOffice,(size/doctorOffice),true);

        int totalCost;
        int constructionCost = size * pricePerSquareMeter;

        if (hospital.getHasRooftop() && hospital.isHasEmergencyRoom()) {
            totalCost = (hospital.getAmountOfElevators() * 10000) + ((constructionCost + buildersCost) * (floors / 2)) + 200000;
        } else if (hospital.getHasRooftop() || hospital.isHasEmergencyRoom()){
            totalCost = (hospital.getAmountOfElevators() * 10000) + ((constructionCost + buildersCost) * (floors / 2)) + 100000;
        } else{
            totalCost = (hospital.getAmountOfElevators() * 10000) + ((constructionCost + buildersCost) * (floors / 2));
        }

        System.out.println("The total of the construction cost of this building is: " + totalCost + " US Dollars.");
        System.out.println("The amount of time that is needed to end this building is: " + constructionDuration + " days.");
        System.out.println("Your Hospital was built on: " + hospital.getCity());
        System.out.println("Your Hospital has " + hospital.getAmountOfDoctorsOffices() + " rooms with an average size of "
                + hospital.getSizeOfOffice() + " Square meters");
        System.out.println("Your Hospital size is: " + hospital.getSizeInSquareMeters() + " Square meters");
        System.out.println("You Hospital has " + hospital.getAmountOfElevators() + " elevators");

        if (hospital.getHasRooftop()) {
            System.out.println("Your Hospital Building has a rooftop");
        } else {
            System.out.println("Your Hospital Building doesn't have a rooftop");
        }

        if (hospital.isHasEmergencyRoom()){
            System.out.println("Your Hospital has an Emergency room");
        } else {
            System.out.println("Your hospital doesn't have an emergency room");
        }

    }
}

