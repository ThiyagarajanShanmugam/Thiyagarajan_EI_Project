
**EXERCISE 1**

# BEHAVIOURAL DESIGN PATTERN

# 1.Cricket Score Updater - Observer Pattern

## Use Case

This console-based application allows users to update and monitor cricket scores. It notifies all registered observers whenever the score is updated, ensuring that all interested parties receive the latest score information.

## Design Pattern

The application uses the **Observer Design Pattern**. This pattern establishes a one-to-many relationship between a subject and its observers. When the subject's state changes, all registered observers are notified and updated automatically.

### How it Relates to the Use Case

- **Subject**: `CricketScoreUpdater` class which maintains the cricket score.
- **Observers**: Any class implementing the `Observer` interface, such as `ScoreObserver`, which will be notified of score updates.

## Classes

- **CricketScoreUpdater**: Manages the list of observers and notifies them when the score is updated.
  
- **Score**: Represents the cricket score with runs, wickets, and overs.

- **Observer**: Interface for all observers that need to be notified of score changes.

- **ScoreObserver**: An implementation of the `Observer` interface that prints the updated score.

- **ConsoleInput**: Utility class for handling console input.

- **CricketScoreUpdaterMain**: Main class that runs the application and provides a menu for updating scores or quitting the application.

---

# 2.Workflow Management System - Mediator Pattern

## Use Case

This application demonstrates a simple Workflow Management System where different tasks need to communicate with each other. The system allows users to add tasks and execute them in sequence. Each task is managed and executed through a central mediator to ensure proper coordination.

## Design Pattern

The **Mediator Pattern** is used to manage communication between various tasks in the workflow without them interacting directly with each other. This reduces the complexity of interactions and centralizes control.

### Relation to Use Case

- **WorkflowMediator**: Acts as the central point for adding and executing tasks, managing their interactions and execution order.

## Classes

- **WorkflowMediator**: Manages a list of tasks and coordinates their execution.

- **Task**: An abstract class representing a task that can be executed. It is extended by concrete task classes.

- **SimpleTask**: A concrete implementation of `Task` that prints a message when executed.

- **WorkflowApplication**: The main application class that interacts with the user, allowing them to add tasks and execute the workflow.

- **LoggerUtil**: Provides logging functionality for tracking task execution and errors.



# CREATIONAL DESIGN PATTERN

# 1.Robot Factory - PROTOTYPE PATTERN

## Use Case

The Robot Factory application simulates a factory where robots are created using the Prototype Design Pattern. Users can clone predefined robot prototypes (WeldingRobot or AssemblyRobot) and either use predefined configurations or customize their settings.

## Design Pattern

**Prototype Design Pattern**:
- **Purpose**: Enables cloning of robot prototypes to create new instances.
- **Relation to Use Case**: Allows creating robots with specific configurations by cloning existing prototypes.

## Classes

- **Robot**: Interface defining `clone` and `performTask` methods.
- **WeldingRobot**: Concrete prototype for welding tasks.
- **AssemblyRobot**: Concrete prototype for assembly tasks.
- **PrototypeRegistry**: Manages and provides access to robot prototypes.
- **RobotFactory**: Factory class that creates robot instances based on user input.
- **InputValidation**: Validates user input for robot type.
- **TransientErrorHandling**: Handles transient errors with retry logic.
- **Logger**: Logs errors and messages.





# 2.Vehicle Rental System - Factory Pattern

## Use Case

This console-based Vehicle Rental System allows users to rent different types of vehicles: Bike, Car, and Truck. The system displays available vehicles and lets users rent a specific vehicle based on their choice.

## Design Pattern: Factory Pattern

The Factory Pattern is utilized to create vehicle objects based on user input. This pattern defines an interface for creating objects but lets subclasses alter the type of objects that will be created. In this system:

- **VehicleFactory**: This is the factory class that handles the creation of Bike, Car, and Truck objects based on the input provided. The pattern abstracts the instantiation process and centralizes it in the VehicleFactory, allowing for easy extension and maintenance.

## Classes

- **VehicleRentalApp**: Entry point of the application. Handles user interaction and orchestrates the vehicle rental process.

- **Vehicle**: Abstract class representing a vehicle with common attributes and methods.

- **Bike, Car, Truck**: Concrete classes extending Vehicle, each representing a specific type of vehicle with its rental price.

- **VehicleFactory**: Factory class responsible for creating vehicle instances based on user input.

- **VehicleRentalException, InvalidVehicleTypeException**: Custom exception classes for error handling.

- **InputValidator**: Utility class for validating user input.

- **RentalService**: Service class that manages available vehicles and processes rental requests.



# STRUCTURAL DESIGN PATTERN


# 1.Notification System - BRIDGE PATTERN

## Use Case

The Notification System demonstrates a system that sends notifications via different channels (Email and SMS) using various service providers (Twilio and SendGrid). It showcases the flexibility of handling different types of notifications and service providers.

## Design Pattern Used

### Bridge Pattern

- **Abstraction:** `Notification` (abstract class)
- **Implementor:** `ServiceProvider` (interface)
- **Refined Abstractions:** `EmailNotification`, `SMSNotification`
- **Concrete Implementors:** `Twilio`, `SendGrid`

The Bridge Pattern is used to decouple the notification type from the service provider. This allows for independent extension of both notification types and service providers without affecting each other.

## Classes Used

- **`Notification`**: Abstract class representing the abstraction for notifications.
- **`EmailNotification`**: Concrete class for email notifications.
- **`SMSNotification`**: Concrete class for SMS notifications.
- **`ServiceProvider`**: Interface defining the contract for service providers.
- **`Twilio`**: Concrete class implementing the `ServiceProvider` interface for Twilio.
- **`SendGrid`**: Concrete class implementing the `ServiceProvider` interface for SendGrid.
- **`Main`**: Client class that interacts with the user to send notifications.



# 2.Organization Structure Manager - COMPOSITE PATTERN

## Use Case

This application models an organization's hierarchical structure, where both departments and employees can be treated uniformly. The structure supports adding departments and employees, and displaying the organization.

## Design Pattern

### Composite Pattern

The Composite pattern is used to represent part-whole hierarchies. In this case:
- **Leaf (Employee)**: Represents individual employees.
- **Composite (Department)**: Represents departments that can contain employees and other departments.

The pattern allows treating both employees and departments uniformly and simplifies the management of hierarchical structures.

## Classes

- **`OrganizationComponent`**: Interface defining common operations for employees and departments.
- **`Employee`**: Implements `OrganizationComponent`, representing individual employees.
- **`Department`**: Implements `OrganizationComponent`, representing departments that can contain other `OrganizationComponent` objects.
- **`Main`**: The main application class to interact with the user and manage the organization.





**EXERCISE 2**

#  🏠 Smart Home System

## Use Case Overview

The Smart Home System is a console-based application designed to simulate a smart home environment. It enables users to control various smart devices through a central hub. The system supports managing devices (lights, thermostats, door locks), scheduling their operations, and automating tasks based on predefined triggers.

### Functionalities

- **Device Management**: Add, remove, and control devices (Lights, Thermostats, Door Locks).
- **Scheduling**: Set activation/deactivation schedules for devices.
- **Automation**: Create triggers based on conditions to automate device actions.
- **Device Status**: View the current status of all devices.

## 🧩 Design Patterns Used

### 1. Observer Pattern

- **Purpose**: To keep all devices updated with changes in the system. This pattern allows the Smart Home Hub (Subject) to notify all registered devices (Observers) when a change occurs.
- **Relation to Use Case**: Devices need to be updated whenever a change happens, such as when a schedule or trigger affects them.

**Classes Involved:**

- **Subject (Abstract class)**: Manages observers and notifies them of changes.
- **DeviceObserver (Interface)**: Defines methods for receiving updates.
- **Device (Abstract class)**: Implements `DeviceObserver` to receive updates.

### 2. Factory Method Pattern

- **Purpose**: To create instances of various device types without specifying their exact classes. This pattern provides a way to instantiate objects based on type.
- **Relation to Use Case**: Facilitates the creation of devices (Lights, Thermostats, Door Locks) dynamically based on user input.

**Classes Involved:**

- **DeviceFactory**: Factory class responsible for creating instances of different device types.

### 3. Proxy Pattern

- **Purpose**: To control access to the real devices and manage interactions. The proxy class wraps the real device and provides additional functionality like status reporting.
- **Relation to Use Case**: Ensures controlled access and status reporting for devices.

**Classes Involved:**

- **DeviceProxy**: Provides access control and status reporting for the real devices.

### 4. Command Pattern (Implicit)

- **Purpose**: Encapsulates requests as objects, allowing them to be executed at a later time or triggered by conditions.
- **Relation to Use Case**: Encapsulates scheduling and trigger actions, making it easier to manage device commands.

**Classes Involved:**

- **Schedule**: Represents a schedule for device operations.
- **Trigger**: Represents automation triggers based on conditions.

## 🗂️ Classes and Their Responsibilities

- **Device.java**: Abstract class defining properties and methods common to all devices.
- **Light.java**: Concrete implementation of `Device` for light devices.
- **Thermostat.java**: Concrete implementation of `Device` for thermostat devices.
- **DoorLock.java**: Concrete implementation of `Device` for door lock devices.
- **DeviceFactory.java**: Factory class for creating device instances.
- **DeviceProxy.java**: Proxy class that wraps around real devices to control access and provide status reporting.
- **Subject.java**: Manages observers (devices) and notifies them of changes.
- **DeviceObserver.java**: Observer interface for device status updates.
- **SmartHomeHub.java**: Central hub for managing devices, schedules, and triggers.
- **Schedule.java**: Represents scheduling information for devices.
- **Trigger.java**: Represents triggers that automate device actions based on conditions.
- **Main.java**: Entry point of the application for user interaction.

## 🛠️ Compiling and Executing

To compile and execute the Java source files, navigate to the `src` (or `Smart_Home_Automation`) directory and use the following command:


        javac -d ../Smart_Home_Automation/**/*.java
To run the application, use the following command:

               java -cp ../out main.Main

## 🛠️ Tech Stack

### Programming Language

- **Java**: The primary language used for implementing the Smart Home System. Java's object-oriented principles and robust ecosystem support the design patterns and architecture used in this project.

### JDK Version

- **JDK 17**: The project is developed using Java Development Kit (JDK) version 17. This version provides a stable and feature-rich environment for developing and running the application.

### Build and Execution

- **Java Compiler (`javac`)**: Used to compile the Java source code into bytecode.
- **Java Runtime (`java`)**: Executes the compiled Java bytecode to run the application.

### Version Control

- **Git**: Used for version control, allowing tracking of changes, collaboration, and management of the codebase.

## 📞 Contact Information

- **Gmail**: [thiyagarajanshanmugam2004@gmail.com](mailto:thiyagarajanshanmugam2004@gmail.com)
- **GitHub**: [ThiyagarajanShanmugam](https://github.com/ThiyagarajanShanmugam)







