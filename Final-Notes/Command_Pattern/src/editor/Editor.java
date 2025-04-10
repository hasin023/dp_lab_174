package editor;

import java.util.Scanner;

import commands.Command;
import commands.CommandHistory;
import commands.CopyCommand;
import commands.CutCommand;
import commands.PasteCommand;
import commands.TypeCommand;

public class Editor {
    private String text = "";
    private String clipboard = "";
    private CommandHistory history = new CommandHistory();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Console Text Editor - Command Pattern Example");
        System.out.println("-------------------------------------------");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = readUserChoice();

            switch (choice) {
                case 1: // Type text
                    typeText();
                    break;
                case 2: // Copy
                    executeCommand(new CopyCommand(this));
                    break;
                case 3: // Cut
                    executeCommand(new CutCommand(this));
                    break;
                case 4: // Paste
                    executeCommand(new PasteCommand(this));
                    break;
                case 5: // Undo
                    undo();
                    break;
                case 0: // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Editor closed.");
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nCurrent text: \"" + text + "\"");
        System.out.println("Clipboard: \"" + (clipboard != null ? clipboard : "") + "\"");
        System.out.println("\nOptions:");
        System.out.println("1. Type text");
        System.out.println("2. Copy (select portion of text)");
        System.out.println("3. Cut (select portion of text)");
        System.out.println("4. Paste");
        System.out.println("5. Undo");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private int readUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void typeText() {
        System.out.print("Enter new text: ");
        String newText = scanner.nextLine();
        executeCommand(new TypeCommand(this, newText));
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
            System.out.println("Command executed.");
        } else {
            System.out.println("Command could not be executed.");
        }
    }

    private void undo() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        Command command = history.pop();
        if (command != null) {
            command.undo();
            System.out.println("Undo completed.");
        }
    }

    // Methods for commands to use
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    public String selectTextPortion() {
        System.out.println("Current text: \"" + text + "\"");
        if (text.isEmpty()) {
            System.out.println("Text is empty, nothing to select.");
            return null;
        }

        int start, end;
        while (true) {
            try {
                System.out.print("Enter start position (0-" + (text.length() - 1) + "): ");
                start = Integer.parseInt(scanner.nextLine());

                if (start < 0 || start >= text.length()) {
                    System.out.println("Invalid position. Try again.");
                    continue;
                }

                System.out.print("Enter end position (" + start + "-" + (text.length()) + "): ");
                end = Integer.parseInt(scanner.nextLine());

                if (end <= start || end > text.length()) {
                    System.out.println("Invalid position. Try again.");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numbers.");
            }
        }

        return text.substring(start, end);
    }
}
