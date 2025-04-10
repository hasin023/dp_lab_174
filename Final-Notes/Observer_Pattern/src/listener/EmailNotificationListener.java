package listener;

import customEvent.FileEvent;

public class EmailNotificationListener implements FileEventListener {
    private final String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void onFileEvent(FileEvent event) {
        System.out.println("Email to " + email + ": File " + event.getFile().getName()
                + " was " + event.getEventType() + " at " + event.getTimestamp());
    }
}