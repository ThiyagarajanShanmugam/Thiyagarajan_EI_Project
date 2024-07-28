package com.factory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PrototypeRegistry registry = new PrototypeRegistry();
        registry.addPrototype("Welding", new WeldingRobot());
        registry.addPrototype("Assembly", new AssemblyRobot());

        RobotFactory factory = new RobotFactory(registry);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter robot type ('W'/'A') or 'E' to quit:");
            String input = scanner.nextLine();

            if ('E'.equalsIgnoreCase(input)) {
                break;
            }

            try {
                String robotType = InputValidation.validateRobotType(input);
                Robot robot = factory.createRobot(robotType);

                System.out.println("Use predefined configuration? (yes/no):");
                String configChoice = scanner.nextLine();

                if ("no".equalsIgnoreCase(configChoice)) {
                    if (robot instanceof WeldingRobot) {
                        System.out.println("Enter welding material:");
                        String material = scanner.nextLine();
                        System.out.println("Enter welding speed:");
                        int speed = Integer.parseInt(scanner.nextLine());
                        ((WeldingRobot) robot).setWeldingMaterial(material);
                        ((WeldingRobot) robot).setWeldingSpeed(speed);
                    } else if (robot instanceof AssemblyRobot) {
                        System.out.println("Enter assembly line:");
                        String line = scanner.nextLine();
                        System.out.println("Enter assembly speed:");
                        int speed = Integer.parseInt(scanner.nextLine());
                        ((AssemblyRobot) robot).setAssemblyLine(line);
                        ((AssemblyRobot) robot).setAssemblySpeed(speed);
                    }
                }

                TransientErrorHandling.retry(robot::performTask, 3, 1000);
            } catch (Exception e) {
                Logger.log("Error: " + e.getMessage());
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
