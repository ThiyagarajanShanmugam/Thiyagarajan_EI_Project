package com;

import com.example.composite.Department;
import com.example.leaf.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Department company = new Department("Company");

            boolean running = true;
            while (running) {
                System.out.println("1. Add Department");
                System.out.println("2. Add Employee");
                System.out.println("3. Display Organization");
                System.out.println("4. Exit");

                int choice = getUserChoice();
                switch (choice) {
                    case 1:
                        addDepartment(company);
                        break;
                    case 2:
                        addEmployee(company);
                        break;
                    case 3:
                        System.out.println(company.getDetails());
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }

    private static int getUserChoice() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                LOGGER.log(Level.WARNING, "Invalid input. Please enter a number", e);
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static void addDepartment(Department company) {
        System.out.print("Enter department name: ");
        String name = scanner.next();
        try {
            Department department = new Department(name);
            company.addComponent(department);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, "Error adding department", e);
        }
    }

    private static void addEmployee(Department company) {
        System.out.print("Enter employee name: ");
        String name = scanner.next();
        System.out.print("Enter employee role: ");
        String role = scanner.next();
        try {
            Employee employee = new Employee(name, role);
            company.addComponent(employee);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, "Error adding employee", e);
        }
    }
}
