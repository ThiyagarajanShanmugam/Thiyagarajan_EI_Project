 
package com.vehiclerental.vehicle;

public class Bike extends Vehicle {
    public Bike() {
        super("Bike", 10.0);
    }

    @Override
    public String getDetails() {
        return "This is a Bike. Rent: $" + getRentalPrice() + " per hour.";
    }
}
