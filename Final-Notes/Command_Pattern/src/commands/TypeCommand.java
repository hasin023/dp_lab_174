package commands;

import editor.Editor;

public class TypeCommand extends Command {
    private String newText;

    public TypeCommand(Editor editor, String newText) {
        super(editor);
        this.newText = newText;
    }

    @Override
    public boolean execute() {
        backup();
        editor.setText(editor.getText() + newText);
        return true;
    }
}