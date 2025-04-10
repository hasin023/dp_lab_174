package listener;

import customEvent.FileEvent;

public interface FileEventListener {
    void onFileEvent(FileEvent event);
}