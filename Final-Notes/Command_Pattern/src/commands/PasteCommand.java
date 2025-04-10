package commands;

import java.util.Scanner;

import editor.Editor;

public class PasteCommand extends Command {
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        String clipboard = editor.getClipboard();
        if (clipboard == null || clipboard.isEmpty()) {
            System.out.println("Clipboard is empty.");
            return false;
        }

        backup();

        System.out.println("Current text: \"" + editor.getText() + "\"");
        System.out.print("Enter position to paste (0-" + editor.getText().length() + "): ");

        try {
            Scanner scanner = new Scanner(System.in);
            int position = Integer.parseInt(scanner.nextLine());

            if (position < 0 || position > editor.getText().length()) {
                System.out.println("Invalid position.");
                return false;
            }

            String text = editor.getText();
            String newText = text.substring(0, position) + clipboard + text.substring(position);
            editor.setText(newText);

            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return false;
        }
    }
}