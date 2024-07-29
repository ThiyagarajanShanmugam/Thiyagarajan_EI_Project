package com.smarthome.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<DeviceObserver> observers = new ArrayList<>();

    public void addObserver(DeviceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DeviceObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (DeviceObserver observer : observers) {
            observer.update();
        }
    }
}
