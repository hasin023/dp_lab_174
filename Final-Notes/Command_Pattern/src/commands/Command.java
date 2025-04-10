package commands;

import editor.Editor;

public abstract class Command {
    protected Editor editor;
    protected String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    protected void backup() {
        backup = editor.getText();
    }

    public void undo() {
        editor.setText(backup);
    }

    public abstract boolean execute();
}
