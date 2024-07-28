 
package com.vehiclerental.service;

import com.vehiclerental.factory.VehicleFactory;
import com.vehiclerental.vehicle.Vehicle;
import com.vehiclerental.util.InputValidator;
import com.vehiclerental.exception.InvalidVehicleTypeException;
import com.vehiclerental.vehicle.Bike;
import com.vehiclerental.vehicle.Car;
import com.vehiclerental.vehicle.Truck;


import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private List<Vehicle> availableVehicles;

    public RentalService() {
        availableVehicles = new ArrayList<>();
        availableVehicles.add(new Bike());
        availableVehicles.add(new Car());
        availableVehicles.add(new Truck());
    }

    public void displayAvailableVehicles() {
        System.out.println("Available vehicles:");
        for (Vehicle vehicle : availableVehicles) {
            System.out.println(vehicle.getDetails());
        }
    }

    public void handleRental(String choice) {
        try {
            String vehicleType = getVehicleTypeFromChoice(choice);
            if (!InputValidator.isValidVehicleType(vehicleType)) {
                System.out.println("Invalid choice. Please enter a valid option.");
                return;
            }

            Vehicle vehicle = VehicleFactory.createVehicle(vehicleType);
            System.out.println("Vehicle rented: " + vehicle.getDetails());
            // Additional logic to remove the rented vehicle from the list can be added here

        } catch (InvalidVehicleTypeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Please try again.");
        }
    }

    private String getVehicleTypeFromChoice(String choice) {
        switch (choice) {
            case "2":
                return "bike";
            case "3":
                return "car";
            case "4":
                return "truck";
            default:
                return "";
        }
    }
}
