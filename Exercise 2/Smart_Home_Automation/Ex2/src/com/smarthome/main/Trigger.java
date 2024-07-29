package com.smarthome.main;

public class Trigger {
    private String condition;
    private String action;

    public Trigger(String condition, String action) {
        this.condition = condition;
        this.action = action;
    }

    public String getCondition() {
        return condition;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Trigger [condition=" + condition + ", action=" + action + "]";
    }
}
