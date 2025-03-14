package main.memento;

import java.io.Serializable;
import java.util.List;

public class EditorMemento implements Serializable {

    private String content;
    private int cursorPosition;
    private List<String> selections;

    public EditorMemento(String content, int cursorPosition, List<String> selections) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.selections = selections;
    }

    public String GetContent() {
        return this.content;
    }

    public int GetCursorPosition() {
        return this.cursorPosition;
    }

    public List<String> GetSelections() {
        return this.selections;
    }
}
