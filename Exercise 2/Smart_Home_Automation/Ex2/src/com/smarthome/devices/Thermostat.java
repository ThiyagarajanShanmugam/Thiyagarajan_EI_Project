package com.smarthome.devices;

public class Thermostat extends Device {
    private int temperature;

    public Thermostat(int id, int initialTemperature) {
        super(id);
        this.temperature = initialTemperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String getStatusDescription() {
        return "Thermostat " + id + " is set to " + temperature + " degrees";
    }
}
