package Strategies;

import Behaviours.ITaskExecutionStrategy;

public class HighSpeedExecution implements ITaskExecutionStrategy {
    @Override
    public String ExecuteTask() {
        return "Task executed at high speed";
    }
}
