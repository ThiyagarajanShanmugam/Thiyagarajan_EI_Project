package com.example.mediator;

public class SimpleTask extends Task {

    public SimpleTask(String name, WorkflowMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void execute() {
        System.out.println("Task " + name + " is executed.");
    }
}
