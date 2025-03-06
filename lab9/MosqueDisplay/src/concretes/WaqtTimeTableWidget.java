package concretes;

import behaviours.IView;

public class WaqtTimeTableWidget implements IView {
    private String _id;
    private String[] timeTable;

    public WaqtTimeTableWidget(String id) {
        _id = id;
        this.timeTable = new String[5];
    }

    @Override
    public String getId() {
        return _id;
    }

    @Override
    public void render() {
        System.out.println("Waqt Time Table:");
        for (int i = 0; i < timeTable.length; i++) {
            System.out.println(timeTable[i]);
        }
    }

    @Override
    public void SetContent(String content) {
        System.out.println("Setting content");
    }
}
