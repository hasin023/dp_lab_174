package customEvent;

import java.io.File;

public class FileEvent {
    private final String eventType;
    private final File file;
    private final String timestamp;

    public FileEvent(String eventType, File file) {
        this.eventType = eventType;
        this.file = file;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public String getEventType() {
        return eventType;
    }

    public File getFile() {
        return file;
    }

    public String getTimestamp() {
        return timestamp;
    }
}