package mediators;

import concretes.CurrentTimeWidget;
import concretes.TimeZoneWidget;

public class ConcreteMediator {
    private TimeZoneWidget tmw = new TimeZoneWidget("tzw1");
    private CurrentTimeWidget ctw = new CurrentTimeWidget("ctw1");

    public void UpdateTimeZone(String timeZone) {
        System.out.println("Timezone before setting");
        tmw.render();

        System.out.println("Current time before update");
        ctw.render();

        System.out.println("Updating timezone");
        tmw.SetContent(timeZone);
        tmw.render();

        System.out.println("Current time changed");
        ctw.SetContent("22333333222121");
        ctw.render();
    }

    // public void UpdateCurrentTime(String currentTime) {
    // ctw.SetContent(currentTime);
    // ctw.render();
    // }
}
