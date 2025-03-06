package abstracs;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Event {
    private final UUID eventId;
    private final LocalDateTime timestamp;
    
    public Event() {
        this.eventId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
    }
    
    public UUID getEventId() {
        return eventId;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
