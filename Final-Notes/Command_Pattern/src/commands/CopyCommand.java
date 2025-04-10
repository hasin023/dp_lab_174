package commands;

import editor.Editor;

public class CopyCommand extends Command {
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        String selectedText = editor.selectTextPortion();
        if (selectedText == null || selectedText.isEmpty()) {
            return false;
        }

        editor.setClipboard(selectedText);
        return false; // No need to store in history as this doesn't change state
    }
}
