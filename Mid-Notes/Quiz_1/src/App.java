import Concretes.*;
import Contexts.*;
import Strategies.*;

public class App {
        public static void main(String[] args) throws Exception {
                CleaningRobot cleaningRobot = new CleaningRobot(new HighSpeedExecution());
                // Set the context with the processor
                TaskExecutionContext context = new TaskExecutionContext(cleaningRobot);

                // Process the task with the initial strategy
                context.Execute();

                // Change the strategy at runtime to PrecisionExecution
                context.SetStrategy(new PrecisionExecution());
                context.Execute();

                // You could also create a RepairRobotProcessor and switch strategies as needed
                RepairRobot repairRobot = new RepairRobot(new HighSpeedExecution());
                TaskExecutionContext repairContext = new TaskExecutionContext(repairRobot);
                repairContext.Execute();
        }

}
