package com.factory;

public class WeldingRobot implements Robot {
    private String weldingMaterial;
    private int weldingSpeed;

    public WeldingRobot() {
        this.weldingMaterial = "Steel";
        this.weldingSpeed = 5;
    }

    public WeldingRobot(String weldingMaterial, int weldingSpeed) {
        this.weldingMaterial = weldingMaterial;
        this.weldingSpeed = weldingSpeed;
    }

    @Override
    public Robot clone() {
        try {
            return (WeldingRobot) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public void performTask() {
        System.out.println("Welding with material: " + weldingMaterial + " at speed: " + weldingSpeed);
    }

    public void setWeldingMaterial(String weldingMaterial) {
        this.weldingMaterial = weldingMaterial;
    }

    public void setWeldingSpeed(int weldingSpeed) {
        this.weldingSpeed = weldingSpeed;
    }
}
