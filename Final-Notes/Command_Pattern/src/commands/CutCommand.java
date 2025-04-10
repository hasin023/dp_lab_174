package commands;

import editor.Editor;

public class CutCommand extends Command {
    private int startPos;
    private int endPos;

    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        String selectedText = editor.selectTextPortion();
        if (selectedText == null || selectedText.isEmpty()) {
            return false;
        }

        backup();

        String text = editor.getText();
        int startPos = text.indexOf(selectedText);
        editor.setClipboard(selectedText);

        String newText = text.substring(0, startPos) + text.substring(startPos + selectedText.length());
        editor.setText(newText);

        return true;
    }
}