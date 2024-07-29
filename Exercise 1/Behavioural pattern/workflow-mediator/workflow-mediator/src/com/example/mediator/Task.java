package com.example.mediator;

public abstract class Task {
    protected WorkflowMediator mediator;
    protected String name;

    public Task(String name, WorkflowMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public abstract void execute();
}
