 
package com.factory;

public interface Robot extends Cloneable {
    Robot clone();
    void performTask();
}
