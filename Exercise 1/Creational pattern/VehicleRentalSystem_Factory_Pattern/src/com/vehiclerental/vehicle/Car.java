 
package com.vehiclerental.vehicle;

public class Car extends Vehicle {
    public Car() {
        super("Car", 50.0);
    }

    @Override
    public String getDetails() {
        return "This is a Car. Rent: $" + getRentalPrice() + " per hour.";
    }
}
