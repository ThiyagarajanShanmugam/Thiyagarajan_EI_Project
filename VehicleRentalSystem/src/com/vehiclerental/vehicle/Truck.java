 
package com.vehiclerental.vehicle;

public class Truck extends Vehicle {
    public Truck() {
        super("Truck", 100.0);
    }

    @Override
    public String getDetails() {
        return "This is a Truck. Rent: $" + getRentalPrice() + " per hour.";
    }
}
