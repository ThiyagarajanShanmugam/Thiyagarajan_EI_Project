package com.factory;

import java.util.HashMap;
import java.util.Map;

public class InputValidation {

    private static final Map<String, String> robotTypeMap = new HashMap<>();

    static {
        robotTypeMap.put("W", "Welding");
        robotTypeMap.put("A", "Assembly");
    }

    public static String validateRobotType(String input) throws RobotCreationException {
        String robotType = robotTypeMap.get(input.toUpperCase());
        if (robotType == null) {
            throw new RobotCreationException("Invalid robot type. Please enter 'W' for Welding or 'A' for Assembly.");
        }
        return robotType;
    }
}
