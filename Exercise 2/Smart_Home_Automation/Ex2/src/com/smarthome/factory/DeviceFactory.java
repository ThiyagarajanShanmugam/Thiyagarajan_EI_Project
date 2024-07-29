package com.smarthome.factory;

import com.smarthome.devices.Device;
import com.smarthome.devices.Light;
import com.smarthome.devices.Thermostat;
import com.smarthome.devices.DoorLock;

public class DeviceFactory {
    public Device createDevice(int id, String type, String additionalInfo) {
        switch (type.toLowerCase()) {
            case "light":
                boolean lightStatus = Boolean.parseBoolean(additionalInfo);
                return new Light(id, lightStatus);
            case "thermostat":
                int temperature = Integer.parseInt(additionalInfo);
                return new Thermostat(id, temperature);
            case "door":
                boolean doorStatus = Boolean.parseBoolean(additionalInfo);
                return new DoorLock(id, doorStatus);
            default:
                throw new IllegalArgumentException("Invalid device type: " + type);
        }
    }
}
