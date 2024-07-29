package com.smarthome.devices;

public abstract class Device {
    protected int id;
    protected boolean status;

    public Device(int id) {
        this.id = id;
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }

    public void turnOn() {
        status = true;
    }

    public void turnOff() {
        status = false;
    }

    public abstract String getStatusDescription();
}
