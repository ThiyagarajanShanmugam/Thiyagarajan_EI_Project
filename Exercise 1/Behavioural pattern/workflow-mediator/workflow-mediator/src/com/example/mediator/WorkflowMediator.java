package com.example.mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.example.utils.LoggerUtil;

public class WorkflowMediator {
    private static final Logger logger = LoggerUtil.getLogger();
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void executeWorkflow() {
        for (Task task : tasks) {
            try {
                logger.info("Executing task: " + task.name);
                task.execute();
            } catch (Exception e) {
                logger.severe("Error executing task " + task.name + ": " + e.getMessage());
            }
        }
    }
}
