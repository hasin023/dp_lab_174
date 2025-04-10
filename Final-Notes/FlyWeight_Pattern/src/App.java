import factory.TreeFactory;
import forest.Forest;

public class App {

    // Reduced numbers for testing
    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 1000000;

    public static void main(String[] args) throws Exception {
        Forest forest = new Forest();

        System.out.println("FLYWEIGHT PATTERN DEMONSTRATION");
        System.out.println("==============================");
        System.out.println("Planting a forest with " + TREES_TO_DRAW + " trees...");

        long startTime = System.currentTimeMillis();

        // Plant summer and autumn oak trees
        for (int i = 0; i < TREES_TO_DRAW / 2; i++) {
            forest.plantTree(
                    random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Summer Oak", "green", "Oak texture stub");

            forest.plantTree(
                    random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Autumn Oak", "orange", "Autumn Oak texture stub");
        }

        long endTime = System.currentTimeMillis();

        // Display visualization and statistics
        forest.visualize();
        forest.displayTrees(5); // Show only first 5 trees

        // Display the flyweight objects (TreeTypes) stored in the factory
        TreeFactory.displayAllTypes();

        // Print memory usage simulation
        System.out.println("\nSTATISTICS:");
        System.out.println("----------");
        System.out.println("Total trees created: " + forest.getTreeCount());
        System.out.println("Unique tree types: " + TreeFactory.getCount());
        System.out.println("Time to create: " + (endTime - startTime) + "ms");

        System.out.println("\nMEMORY USAGE SIMULATION:");
        System.out.println("-----------------------");
        System.out.println("With Flyweight Pattern:");
        System.out.println(
                "  Tree objects: " + TREES_TO_DRAW + " × 8 bytes = " + (TREES_TO_DRAW * 8 / 1024 / 1024) + "MB");
        System.out.println("  TreeType objects: " + TreeFactory.getCount() + " × 30 bytes = "
                + (TreeFactory.getCount() * 30 / 1024) + "KB");
        System.out.println("  Total: ~" + ((TREES_TO_DRAW * 8 + TreeFactory.getCount() * 30) / 1024 / 1024) + "MB");

        System.out.println("\nWithout Flyweight Pattern:");
        System.out.println("  Tree+TreeType combined objects: " + TREES_TO_DRAW + " × 38 bytes = "
                + (TREES_TO_DRAW * 38 / 1024 / 1024) + "MB");

        System.out.println("\nFLYWEIGHT PATTERN KEY POINTS:");
        System.out.println("---------------------------");
        System.out.println("1. Intrinsic state (shared): tree type, color, texture data");
        System.out.println("2. Extrinsic state (unique per object): x and y position");
        System.out.println("3. Factory ensures we create each tree type only once");
        System.out.println("4. Result: massive memory savings when using many similar objects");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
