package editor;

import java.io.File;

import publisher.EventManager;

public class FileEditor {
    public final EventManager events;
    private File file;

    public FileEditor() {
        this.events = new EventManager("open", "save", "close");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        System.out.println("Opening file: " + filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            System.out.println("Saving changes to file: " + file.getName());
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }

    public void closeFile() throws Exception {
        if (this.file != null) {
            System.out.println("Closing file: " + file.getName());
            events.notify("close", file);
            this.file = null;
        } else {
            throw new Exception("No file is currently open.");
        }
    }
}
