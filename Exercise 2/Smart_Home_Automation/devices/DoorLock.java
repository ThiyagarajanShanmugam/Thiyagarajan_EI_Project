package com.smarthome.devices;

public class DoorLock extends Device {
    public DoorLock(int id, boolean initialStatus) {
        super(id);
        this.status = initialStatus;
    }

    @Override
    public String getStatusDescription() {
        return "Door " + id + " is " + (status ? "Locked" : "Unlocked");
    }
}
