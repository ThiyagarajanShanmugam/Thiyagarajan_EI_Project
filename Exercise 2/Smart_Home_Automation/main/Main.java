package com.smarthome.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Available commands:");
            System.out.println("1. Add device");
            System.out.println("2. Remove device");
            System.out.println("3. Turn device on");
            System.out.println("4. Turn device off");
            System.out.println("5. Show device status");
            System.out.println("6. Set schedule");
            System.out.println("7. Add trigger");
            System.out.println("8. Show schedules");
            System.out.println("9. Show triggers");
            System.out.println("10. Exit");

            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Enter device ID, type (light/thermostat/door), and additional info:");
                    String[] addDeviceInput = scanner.nextLine().split(",");
                    hub.addDevice(Integer.parseInt(addDeviceInput[0].trim()), addDeviceInput[1].trim(), addDeviceInput[2].trim());
                    break;
                case "2":
                    System.out.println("Enter device ID to remove:");
                    int removeId = Integer.parseInt(scanner.nextLine().trim());
                    hub.removeDevice(removeId);
                    break;
                case "3":
                    System.out.println("Enter device ID to turn on:");
                    int turnOnId = Integer.parseInt(scanner.nextLine().trim());
                    hub.turnDeviceOn(turnOnId);
                    break;
                case "4":
                    System.out.println("Enter device ID to turn off:");
                    int turnOffId = Integer.parseInt(scanner.nextLine().trim());
                    hub.turnDeviceOff(turnOffId);
                    break;
                case "5":
                    hub.showDeviceStatus();
                    break;
                case "6":
                    System.out.println("Enter device ID, time, and command:");
                    String[] scheduleInput = scanner.nextLine().split(",");
                    hub.setSchedule(Integer.parseInt(scheduleInput[0].trim()), scheduleInput[1].trim(), scheduleInput[2].trim());
                    break;
                case "7":
                    System.out.println("Enter condition and action for trigger:(e.g., \"temperature > 75, turnOff(1)\")");
                    String[] triggerInput = scanner.nextLine().split(",");
                    hub.addTrigger(triggerInput[0].trim(), triggerInput[1].trim());
                    break;
                case "8":
                    hub.getSchedules().forEach(System.out::println);
                    break;
                case "9":
                    hub.getTriggers().forEach(System.out::println);
                    break;
                case "10":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
