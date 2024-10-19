package Concretes;

import Abstracts.Robot;
import Behaviours.ITaskExecutionStrategy;

public class CleaningRobot extends Robot {
    public CleaningRobot(ITaskExecutionStrategy taskExecutionStrategy) {
        super(taskExecutionStrategy);
    }

    @Override
    protected void InitializeRobot() {
        System.out.println("Cleaning robot initialized");
    }

    @Override
    protected void MoveToLocation() {
        System.out.println("Cleaning robot moving to location");
    }

    @Override
    protected void ShutdownRobot() {
        System.out.println("Cleaning robot shutting down");
    }
}
