package trees;

public class TreeType {
    // Contains state shared by several trees
    private String name;
    private String color;
    private String otherTreeData;

    public TreeType(String name, String color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getOtherTreeData() {
        return otherTreeData;
    }
}