package com.example.leaf;

import com.example.component.OrganizationComponent;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee implements OrganizationComponent {
    private static final Logger LOGGER = Logger.getLogger(Employee.class.getName());
    
    private String name;
    private String role;

    public Employee(String name, String role) {
        if (name == null || role == null) {
            LOGGER.log(Level.SEVERE, "Name and role cannot be null");
            throw new IllegalArgumentException("Name and role cannot be null");
        }
        this.name = name;
        this.role = role;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return name + " (" + role + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && role.equals(employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }
}
