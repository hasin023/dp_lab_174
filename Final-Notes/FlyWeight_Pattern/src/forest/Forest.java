package forest;

import factory.TreeFactory;
import trees.Tree;
import trees.TreeType;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private List<Tree> trees = new ArrayList<>();
    private static final int GRID_SIZE = 10;
    private char[][] grid;

    public Forest() {
        grid = new char[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public void plantTree(int x, int y, String name, String color, String data) {
        // Use the factory to get a TreeType (either existing or new)
        TreeType type = TreeFactory.getTreeType(name, color, data);

        // Create a new Tree with its unique position and shared TreeType
        Tree tree = new Tree(x, y, type);
        trees.add(tree);

        // Update visualization grid
        int gridX = Math.min(x % GRID_SIZE, GRID_SIZE - 1);
        int gridY = Math.min(y % GRID_SIZE, GRID_SIZE - 1);
        grid[gridY][gridX] = name.contains("Summer") ? 'S' : 'A';
    }

    public void displayTrees(int limit) {
        System.out.println("\nSample of trees (first " + limit + "):");
        for (int i = 0; i < Math.min(limit, trees.size()); i++) {
            trees.get(i).display();
        }

        if (trees.size() > limit) {
            System.out.println("... and " + (trees.size() - limit) + " more trees");
        }
    }

    public void visualize() {
        System.out.println("\nForest Visualization (S=Summer Oak, A=Autumn Oak):");
        System.out.println("(10x10 sample area)");

        // Print column headers
        System.out.print("  ");
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Print grid with row headers
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getTreeCount() {
        return trees.size();
    }
}