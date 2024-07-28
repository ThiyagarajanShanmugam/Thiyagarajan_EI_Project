package com.factory;

public class AssemblyRobot implements Robot {
    private String assemblyLine;
    private int assemblySpeed;

    public AssemblyRobot() {
        this.assemblyLine = "Line A";
        this.assemblySpeed = 10;
    }

    public AssemblyRobot(String assemblyLine, int assemblySpeed) {
        this.assemblyLine = assemblyLine;
        this.assemblySpeed = assemblySpeed;
    }

    @Override
    public Robot clone() {
        try {
            return (AssemblyRobot) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public void performTask() {
        System.out.println("Assembling on: " + assemblyLine + " at speed: " + assemblySpeed);
    }

    public void setAssemblyLine(String assemblyLine) {
        this.assemblyLine = assemblyLine;
    }

    public void setAssemblySpeed(int assemblySpeed) {
        this.assemblySpeed = assemblySpeed;
    }
}
