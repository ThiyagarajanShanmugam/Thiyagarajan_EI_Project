package com.smarthome.proxy;

import com.smarthome.devices.Device;

public class DeviceProxy extends Device {
    private Device realDevice;

    public DeviceProxy(Device realDevice) {
        super(realDevice.getId());
        this.realDevice = realDevice;
    }

    @Override
    public boolean getStatus() {
        return realDevice.getStatus();
    }

    @Override
    public void turnOn() {
        realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        realDevice.turnOff();
    }

    @Override
    public String getStatusDescription() {
        return realDevice.getStatusDescription();
    }
}
