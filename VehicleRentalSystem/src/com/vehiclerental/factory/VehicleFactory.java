 
package com.vehiclerental.factory;

import com.vehiclerental.vehicle.Vehicle;
import com.vehiclerental.vehicle.Bike;
import com.vehiclerental.vehicle.Car;
import com.vehiclerental.vehicle.Truck;
import com.vehiclerental.exception.InvalidVehicleTypeException;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType) throws InvalidVehicleTypeException {
        switch (vehicleType.toLowerCase()) {
            case "bike":
                return new Bike();
            case "car":
                return new Car();
            case "truck":
                return new Truck();
            default:
                throw new InvalidVehicleTypeException("Invalid vehicle type: " + vehicleType);
        }
    }
}
