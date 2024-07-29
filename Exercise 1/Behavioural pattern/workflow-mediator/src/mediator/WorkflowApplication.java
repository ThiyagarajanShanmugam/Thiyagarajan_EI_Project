package com.example.mediator;

import java.util.Scanner;
import java.util.logging.Logger;
import com.example.utils.LoggerUtil;

public class WorkflowApplication {
    private static final Logger logger = LoggerUtil.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkflowMediator mediator = new WorkflowMediator();

        System.out.println("Workflow Management System");
        boolean running = true;

        while (running) {
            System.out.println("1. Add Task");
            System.out.println("2. Execute Workflow");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    Task task = new SimpleTask(name, mediator);
                    mediator.addTask(task);
                    logger.info("Task added: " + name);
                    break;
                case 2:
                    mediator.executeWorkflow();
                    break;
                case 3:
                    running = false;
                    logger.info("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
