package main.features;

import java.util.ArrayList;
import java.util.List;

import main.core.TextEditor;
import main.memento.EditorMemento;

public class History {
    private TextEditor editor;
    private final List<EditorMemento> mementos;

    public History(TextEditor editor) {
        this.editor = editor;
        this.mementos = new ArrayList<>();
    }

    public void Backup() {
        this.mementos.add(this.editor.CreateMemento());
    }
}
