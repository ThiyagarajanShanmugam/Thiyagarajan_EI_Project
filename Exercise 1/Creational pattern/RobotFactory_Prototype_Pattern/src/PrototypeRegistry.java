 
package com.factory;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
    private Map<String, Robot> prototypes = new HashMap<>();

    public void addPrototype(String key, Robot prototype) {
        prototypes.put(key, prototype);
    }

    public Robot getPrototype(String key) {
        Robot prototype = prototypes.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("No prototype registered for key: " + key);
        }
        return prototype.clone();
    }
}
