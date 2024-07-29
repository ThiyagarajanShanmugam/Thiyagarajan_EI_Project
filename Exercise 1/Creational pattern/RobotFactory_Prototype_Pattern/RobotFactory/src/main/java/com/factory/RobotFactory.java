 
package com.factory;

public class RobotFactory {
    private PrototypeRegistry prototypeRegistry;

    public RobotFactory(PrototypeRegistry prototypeRegistry) {
        this.prototypeRegistry = prototypeRegistry;
    }

    public Robot createRobot(String type) {
        try {
            return prototypeRegistry.getPrototype(type);
        } catch (Exception e) {
            Logger.log(e.getMessage());
            throw new RobotCreationException("Error creating robot: " + e.getMessage());
        }
    }
}
