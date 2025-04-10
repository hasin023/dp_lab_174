package factory;

import java.util.HashMap;
import java.util.Map;

import trees.TreeType;

public class TreeFactory {
    // This map stores our flyweight objects (the TreeTypes)
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String data) {
        // Create a unique key for this tree type
        String key = name + "_" + color;

        // Check if we already have this tree type
        if (!treeTypes.containsKey(key)) {
            // If not, create a new one and store it
            System.out.println("Creating new tree type: " + name + " (" + color + ")");
            treeTypes.put(key, new TreeType(name, color, data));
        }

        // Return the existing or newly created tree type
        return treeTypes.get(key);
    }

    // Helper methods for demonstration
    public static int getCount() {
        return treeTypes.size();
    }

    public static void displayAllTypes() {
        System.out.println("\nAll tree types in the factory:");
        System.out.println("-----------------------------");

        for (String key : treeTypes.keySet()) {
            TreeType type = treeTypes.get(key);
            System.out.println("- " + type.getName() + " with " + type.getColor() +
                    " leaves (" + type.getOtherTreeData() + ")");
        }
    }
}
