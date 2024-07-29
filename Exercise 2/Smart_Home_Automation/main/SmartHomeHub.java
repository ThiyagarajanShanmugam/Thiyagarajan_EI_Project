package com.smarthome.main;

import com.smarthome.devices.Device;
import com.smarthome.factory.DeviceFactory;
import com.smarthome.proxy.DeviceProxy;
import com.smarthome.observer.Subject;
import java.util.*;

public class SmartHomeHub extends Subject {
    private Map<Integer, DeviceProxy> devices = new HashMap<>();
    private List<Schedule> schedules = new ArrayList<>();
    private List<Trigger> triggers = new ArrayList<>();

    private static final List<String> COMMANDS = Arrays.asList(
            "turnOn(id)",
            "turnOff(id)",
            "setSchedule(deviceId, time, command)",
            "addTrigger(condition, action)"
    );

    private DeviceFactory factory = new DeviceFactory();

    public void addDevice(int id, String type, String additionalInfo) {
        if (devices.containsKey(id)) {
            System.out.println("Device with this ID already exists.");
            return;
        }
        try {
            Device device = factory.createDevice(id, type, additionalInfo);
            DeviceProxy proxy = new DeviceProxy(device);
            devices.put(id, proxy);
            notifyObservers();
            System.out.println("Device added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding device: " + e.getMessage());
        }
    }

    public void removeDevice(int id) {
        if (devices.remove(id) != null) {
            notifyObservers();
            System.out.println("Device removed successfully.");
        } else {
            System.out.println("Device not found.");
        }
    }

    public void turnDeviceOn(int id) {
        DeviceProxy device = devices.get(id);
        if (device != null) {
            device.turnOn();
            notifyObservers();
            System.out.println("Device turned on.");
        } else {
            System.out.println("Device not found.");
        }
    }

    public void turnDeviceOff(int id) {
        DeviceProxy device = devices.get(id);
        if (device != null) {
            device.turnOff();
            notifyObservers();
            System.out.println("Device turned off.");
        } else {
            System.out.println("Device not found.");
        }
    }

    public void showDeviceStatus() {
        for (DeviceProxy device : devices.values()) {
            System.out.println(device.getStatusDescription());
        }
    }

    public void setSchedule(int deviceId, String time, String command) {
        if (devices.containsKey(deviceId)) {
            schedules.add(new Schedule(deviceId, time, command));
            System.out.println("Schedule set successfully.");
        } else {
            System.out.println("Device not found.");
        }
    }

    public void addTrigger(String condition, String action) {
        showAvailableCommands();
        triggers.add(new Trigger(condition, action));
        System.out.println("Trigger added successfully.");
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<Trigger> getTriggers() {
        return triggers;
    }

    private void showAvailableCommands() {
        System.out.println("Available commands for triggers:");
        for (String command : COMMANDS) {
            System.out.println(command);
        }
    }
}
