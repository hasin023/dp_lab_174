package main.features;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public void SaveToFile(String filePath) {
        if (this.mementos.isEmpty()) {
            System.out.println("No mementos to save");
            return;
        }
        try {
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this.mementos.peek());
            out.close();
            file.close();

            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public void LoadFromFile(String filePath) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            this.mementos.clear();
            EditorMemento memento = (EditorMemento) in.readObject();
            this.mementos.push(memento);

            in.close();
            file.close();

            System.out.println("Object has been deserialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}
