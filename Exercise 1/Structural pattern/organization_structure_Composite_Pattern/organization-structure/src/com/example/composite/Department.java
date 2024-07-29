package com.example.composite;

import com.example.component.OrganizationComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Department implements OrganizationComponent {
    private static final Logger LOGGER = Logger.getLogger(Department.class.getName());

    private String name;
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        if (name == null) {
            LOGGER.log(Level.SEVERE, "Department name cannot be null");
            throw new IllegalArgumentException("Department name cannot be null");
        }
        this.name = name;
    }

    public void addComponent(OrganizationComponent component) {
        if (component == null) {
            LOGGER.log(Level.WARNING, "Attempted to add null component");
            throw new IllegalArgumentException("Component cannot be null");
        }
        components.add(component);
    }

    public void removeComponent(OrganizationComponent component) {
        if (component == null) {
            LOGGER.log(Level.WARNING, "Attempted to remove null component");
            throw new IllegalArgumentException("Component cannot be null");
        }
        components.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder(name + ":\n");
        for (OrganizationComponent component : components) {
            details.append("  ").append(component.getDetails()).append("\n");
        }
        return details.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return name.equals(that.name) && components.equals(that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, components);
    }
}
