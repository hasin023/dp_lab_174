package publisher;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customEvent.FileEvent;
import listener.FileEventListener;

public class EventManager {
    private final Map<String, List<FileEventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, FileEventListener listener) {
        List<FileEventListener> users = listeners.get(eventType);
        if (users != null) {
            users.add(listener);
        }
    }

    public void unsubscribe(String eventType, FileEventListener listener) {
        List<FileEventListener> users = listeners.get(eventType);
        if (users != null) {
            users.remove(listener);
        }
    }

    public void notify(String eventType, File file) {
        List<FileEventListener> users = listeners.get(eventType);
        if (users != null) {
            FileEvent event = new FileEvent(eventType, file);
            for (FileEventListener listener : users) {
                listener.onFileEvent(event);
            }
        }
    }
}
