package main;

import main.core.TextEditor;
import main.memento.EditorMemento;

public class App {
    public static void main(String[] args) throws Exception {
        TextEditor editor = new TextEditor();

        editor.SetContent("Goodbye World 🔥🔥");
        editor.SetCursorPosition(5);
        editor.AddSelection("World");
        editor.DisplayState();

        EditorMemento memento = editor.CreateMemento();

        editor.SetContent("Final Farewell World 🔥🔥");
        editor.SetCursorPosition(16);
        editor.ClearSelections();
        editor.DisplayState();

        editor.RestoreFromMemento(memento);
        editor.DisplayState();
    }
}
