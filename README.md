

**EXERCISE 2**

**🏠 Smart Home System**

Use Case Overview

The Smart Home System is a console-based application designed to simulate a smart home environment. It enables users to control various smart devices through a central hub. The system supports managing devices (lights, thermostats, door locks), scheduling their operations, and automating tasks based on predefined triggers.

**Functionalities:**



    Device Management: Add, remove, and control devices (Lights, Thermostats, Door Locks).
    
    Scheduling: Set activation/deactivation schedules for devices.
    
    Automation: Create triggers based on conditions to automate device actions.
    
    Device Status: View the current status of all devices.


🧩 Design Patterns Used
    
    1. Observer Pattern
       
    Purpose: To keep all devices updated with changes in the system. This pattern allows the Smart Home Hub (Subject) to notify all registered devices (Observers) when a change occurs.
    
    Relation to Use Case: Devices need to be updated whenever a change happens, such as when a schedule or trigger affects them.
    Classes Involved:
    
    Subject (Abstract class): Manages observers and notifies them of changes.
    
    DeviceObserver (Interface): Defines methods for receiving updates.
    
    Device (Abstract class): Implements DeviceObserver to receive updates.
    
    2. Factory Method Pattern 
    
    Purpose: To create instances of various device types without specifying their exact classes. This pattern provides a way to instantiate objects based on type.
    
    Relation to Use Case: Facilitates the creation of devices (Lights, Thermostats, Door Locks) dynamically based on user input.
    
    Classes Involved:
    DeviceFactory: Factory class responsible for creating instances of different device types.
    
    3. Proxy Pattern 
    
    Purpose: To control access to the real devices and manage interactions. The proxy class wraps the real device and provides additional functionality like status reporting.
    
    Relation to Use Case: Ensures controlled access and status reporting for devices.
    
    Classes Involved:
    DeviceProxy: Provides access control and status reporting for the real devices.
    
    4. Command Pattern (Implicit) 
    
    Purpose:   Encapsulates requests as objects, allowing them to be executed at a later time or triggered by conditions.
    
    Relation to Use Case:   Encapsulates scheduling and trigger actions, making it easier to manage device commands.
    
    Classes Involved:
    
    Schedule: Represents a schedule for device operations.
    
    Trigger: Represents automation triggers based on conditions.

🗂️ Classes and Their Responsibilities

    Device.java: Abstract class defining properties and methods common to all devices.
    
    Light.java: Concrete implementation of Device for light devices.
    
    Thermostat.java: Concrete implementation of Device for thermostat devices.
    
    DoorLock.java: Concrete implementation of Device for door lock devices.
    
    DeviceFactory.java: Factory class for creating device instances.
    
    DeviceProxy.java: Proxy class that wraps around real devices to control access and provide status reporting.
    
    Subject.java: Manages observers (devices) and notifies them of changes.
    
    DeviceObserver.java: Observer interface for device status updates.
    
    SmartHomeHub.java: Central hub for managing devices, schedules, and triggers.
    
    Schedule.java: Represents scheduling information for devices.
    
    Trigger.java: Represents triggers that automate device actions based on conditions.
    
    Main.java: Entry point of the application for user interaction.

🛠️ Compiling and Executing

To compile the Java source files, navigate to the src(here Smart_Home_Automation) directory and use the following command:

    javac -d ../Smart_Home_Automation/**/*.java

🚀 Run the Application

To run the application, use the following command:

    java -cp ../out.main.Main
