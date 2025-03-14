package main.features;

import java.util.Stack;

import main.core.TextEditor;
import main.memento.EditorMemento;

public class History {
    private TextEditor editor;
    private final Stack<EditorMemento> mementos;

    public History(TextEditor editor) {
        this.editor = editor;
        this.mementos = new Stack<>();
    }

    public EditorMemento Backup() {
        EditorMemento newMemento = this.editor.CreateMemento();
        this.mementos.push(newMemento);
        return newMemento;
    }

    public void Undo() {
        if (this.mementos.isEmpty()) {
            return;
        }

        EditorMemento memento = this.mementos.pop();
        this.editor.RestoreFromMemento(memento);
    }
}
