 
package com.vehiclerental.vehicle;

public abstract class Vehicle {
    private String vehicleType;
    private double rentalPrice;

    public Vehicle(String vehicleType, double rentalPrice) {
        this.vehicleType = vehicleType;
        this.rentalPrice = rentalPrice;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public abstract String getDetails();
}
