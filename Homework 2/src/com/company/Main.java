package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int op;

        do {
            Scanner scanner = new Scanner(System.in);
            Company company = new Company();
            company.startMenu();

            System.out.println("\n\n\n\n Program Ended" +
                    "\nDo you want to restart?(1=Yes, 2=No):");
            op = scanner.nextInt();

        } while (op !=2);

    }

}
