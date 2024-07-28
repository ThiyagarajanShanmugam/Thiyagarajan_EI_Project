package com.airport;

import com.airport.airplane.Airplane;
import com.airport.mediator.ATCMediator;
import com.airport.mediator.ATCMediatorImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, Airplane> airplanes = new HashMap<>();
    private static final ATCMediator mediator = new ATCMediatorImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command: 1 - Add Airplane, 2 - Takeoff, 3 - Landing, 4 - Taxi, 0 - Exit");
            int command = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (command) {
                case 1:
                    addAirplane(scanner);
                    break;
                case 2:
                    handleTakeoff(scanner);
                    break;
                case 3:
                    handleLanding(scanner);
                    break;
                case 4:
                    handleTaxi(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private static void addAirplane(Scanner scanner) {
        System.out.println("Enter airplane ID:");
        String id = scanner.nextLine();
        if (!airplanes.containsKey(id)) {
            Airplane airplane = new Airplane(id, mediator);
            airplanes.put(id, airplane);
            System.out.println("Airplane " + id + " added.");
        } else {
            System.out.println("Airplane ID already exists.");
        }
    }

    private static void handleTakeoff(Scanner scanner) {
        System.out.println("Enter airplane ID for takeoff:");
        String id = scanner.nextLine();
        Airplane airplane = airplanes.get(id);
        if (airplane != null) {
            airplane.requestTakeoff();
        } else {
            System.out.println("Airplane ID not found.");
        }
    }

    private static void handleLanding(Scanner scanner) {
        System.out.println("Enter airplane ID for landing:");
        String id = scanner.nextLine();
        Airplane airplane = airplanes.get(id);
        if (airplane != null) {
            airplane.requestLanding();
        } else {
            System.out.println("Airplane ID not found.");
        }
    }

    private static void handleTaxi(Scanner scanner) {
        System.out.println("Enter airplane ID for taxi:");
        String id = scanner.nextLine();
        Airplane airplane = airplanes.get(id);
        if (airplane != null) {
            airplane.requestTaxi();
        } else {
            System.out.println("Airplane ID not found.");
        }
    }
}

