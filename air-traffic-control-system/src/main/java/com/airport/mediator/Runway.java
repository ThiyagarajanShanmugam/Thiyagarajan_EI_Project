package com.airport.mediator;

public class Runway {
    private boolean isAvailable;

    public Runway() {
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

