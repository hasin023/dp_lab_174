package Strategies;

import Behaviours.ITaskExecutionStrategy;

public class PrecisionExecution implements ITaskExecutionStrategy {
    @Override
    public String ExecuteTask() {
        return "Task executed with precision";
    }
}
