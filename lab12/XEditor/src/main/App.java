package main;

import main.core.TextEditor;
import main.features.History;
import main.memento.EditorMemento;

public class App {
    public static void main(String[] args) throws Exception {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        // 1st state
        editor.SetContent("Goodbye World 🔥🔥");
        editor.SetCursorPosition(5);
        editor.AddSelection("World");
        editor.DisplayState();
        EditorMemento state1 = history.Backup();
        System.out.println("State 1 saved to history");

        // 2nd state
        editor.SetContent("Farewell World 🔥🔥");
        editor.SetCursorPosition(16);
        editor.ClearSelections();
        editor.DisplayState();
        EditorMemento state2 = history.Backup();
        System.out.println("State 2 saved to history");

        // 3rd state
        editor.SetContent("Final Farewell World 🔥🔥");
        editor.SetCursorPosition(22);
        editor.ClearSelections();
        editor.DisplayState();
        EditorMemento state3 = history.Backup();
        System.out.println("State 3 saved to history");

        // System.out.println("Reverting to previous state...");
        // history.Undo();
        // editor.DisplayState();

        System.out.println("Reverting to state 1");
        editor.RestoreFromMemento(state1);
        editor.DisplayState();

        System.out.println("Reverting to state 3");
        editor.RestoreFromMemento(state3);
        editor.DisplayState();
    }
}