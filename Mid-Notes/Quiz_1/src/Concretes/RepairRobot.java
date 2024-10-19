package Concretes;

import Abstracts.Robot;
import Behaviours.ITaskExecutionStrategy;

public class RepairRobot extends Robot {
    public RepairRobot(ITaskExecutionStrategy taskExecutionStrategy) {
        super(taskExecutionStrategy);
    }

    @Override
    protected void InitializeRobot() {
        System.out.println("Repair robot initialized");
    }

    @Override
    protected void MoveToLocation() {
        System.out.println("Repair robot moving to location");
    }

    @Override
    protected void ShutdownRobot() {
        System.out.println("Repair robot shutting down");
    }

}
