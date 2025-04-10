package main.core;

import java.util.ArrayList;
import java.util.List;

import main.memento.EditorMemento;

public class TextEditor {
    private String content;
    private int cursorPosition;
    private List<String> selections;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
        this.selections = new ArrayList<>();
    }

    public void SetContent(String content) {
        this.content = content;
        this.cursorPosition = Math.min(this.cursorPosition, this.content.length());
    }

    public void SetCursorPosition(int position) {
        this.cursorPosition = position;
    }

    public void AddSelection(String selection) {
        this.selections.add(selection);
    }

    public void ClearSelections() {
        this.selections.clear();
    }

    public void DisplayState() {
        System.out.println("----- Editor State -----");
        System.out.println("Content: " + this.content);
        System.out.println("Cursor Position: " + this.cursorPosition);
        System.out.println("Selections:");
        if (this.selections.isEmpty()) {
            System.out.println("N/A");
        } else {
            for (String selection : this.selections) {
                System.out.println(" - " + selection);
            }
        }
        System.out.println("------------------------");
    }

    public EditorMemento CreateMemento() {
        List<String> copySelections = new ArrayList<>(this.selections);
        return new EditorMemento(this.content, this.cursorPosition, copySelections);
    }

    public void RestoreFromMemento(EditorMemento memento) {
        if (memento != null) {
            this.content = memento.GetContent();
            this.cursorPosition = memento.GetCursorPosition();
            this.selections = memento.GetSelections();
        }
    }
}