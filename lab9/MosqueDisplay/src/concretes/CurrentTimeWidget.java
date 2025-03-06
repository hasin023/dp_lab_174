package concretes;

import behaviours.IView;

public class CurrentTimeWidget implements IView {
    private String _id;
    private long currentTimeStamp;

    public CurrentTimeWidget(String id) {
        _id = id;
        currentTimeStamp = System.currentTimeMillis();
    }

    @Override
    public String getId() {
        return _id;
    }

    @Override
    public void render() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String readableDate = sdf.format(new java.util.Date(currentTimeStamp));

        System.out.println("Current time: " + readableDate);
    }

    @Override
    public void SetContent(String content) {
        currentTimeStamp = Long.parseLong(content);
    }
}
