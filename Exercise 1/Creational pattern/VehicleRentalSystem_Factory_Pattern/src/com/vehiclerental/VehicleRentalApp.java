package com.vehiclerental;

import com.vehiclerental.service.RentalService;

import java.util.Scanner;

public class VehicleRentalApp {
    public static void main(String[] args) {
        System.out.println("Starting Vehicle Rental System...");

        RentalService rentalService = new RentalService();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Vehicle Rental System");
            System.out.println("1. Display available vehicles");
            System.out.println("2. Rent a Bike");
            System.out.println("3. Rent a Car");
            System.out.println("4. Rent a Truck");
            System.out.println("5. Exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    rentalService.displayAvailableVehicles();
                    break;
                case "2":
                case "3":
                case "4":
                    rentalService.handleRental(choice);
                    break;
                case "5":
                    System.out.println("Exiting Vehicle Rental System.");
                    System.out.println("Thank you for using the Vehicle Rental System.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}

