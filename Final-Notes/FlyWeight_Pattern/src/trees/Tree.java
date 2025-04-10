package trees;

public class Tree {
    // Contains state unique for each tree
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void display() {
        System.out.println("Tree at position (" + x + "," + y + "): " + type.getName() +
                " with " + type.getColor() + " leaves");
    }
}