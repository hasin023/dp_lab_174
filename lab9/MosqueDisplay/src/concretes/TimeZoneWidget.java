package concretes;

import behaviours.ISetting;

public class TimeZoneWidget implements ISetting {
    private String _id;
    private String timeZone;

    public TimeZoneWidget(String id) {
        _id = id;
        timeZone = "Not Set";
    }

    public String getTimeZone() {
        return timeZone;
    }

    @Override
    public String getId() {
        return _id;
    }

    @Override
    public void render() {
        System.out.println("Time Zone: " + timeZone);
    }

    @Override
    public void SetContent(String content) {
        timeZone = content;
    }
}
