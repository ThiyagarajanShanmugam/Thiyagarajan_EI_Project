 
package com.vehiclerental.util;

public class InputValidator {
    public static boolean isValidVehicleType(String vehicleType) {
        return vehicleType.equalsIgnoreCase("bike") ||
               vehicleType.equalsIgnoreCase("car") ||
               vehicleType.equalsIgnoreCase("truck");
    }
}
