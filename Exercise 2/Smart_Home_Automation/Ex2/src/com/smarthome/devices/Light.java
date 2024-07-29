package com.smarthome.devices;

public class Light extends Device {
    public Light(int id, boolean initialStatus) {
        super(id);
        this.status = initialStatus;
    }

    @Override
    public String getStatusDescription() {
        return "Light " + id + " is " + (status ? "On" : "Off");
    }
}
