package Contexts;

import Abstracts.Robot;
import Behaviours.ITaskExecutionStrategy;

public class TaskExecutionContext {
    private final Robot _processor;

    public TaskExecutionContext(Robot processor) {
        _processor = processor;
    }

    public void SetStrategy(ITaskExecutionStrategy strategy) {
        _processor.TaskExecutionStrategy = strategy;
    }

    public void Execute() {
        _processor.ProcessTask();
    }
}
