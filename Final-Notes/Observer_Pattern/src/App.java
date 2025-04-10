import java.util.Scanner;

import editor.FileEditor;
import listener.EmailNotificationListener;

public class App {
    public static void main(String[] args) throws Exception {
        FileEditor editor = new FileEditor();
        Scanner scanner = new Scanner(System.in);

        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));
        editor.saveFile();

        boolean running = true;

        System.out.println("Welcome to File Editor");
        System.out.println("=====================");

        while (running) {
            System.out.println("\nMenu Options:");
            System.out.println("1. Open a file");
            System.out.println("2. Save current file");
            System.out.println("3. Close current file");
            System.out.println("4. Exit application");
            System.out.print("\nEnter your choice (1-4): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter file path to open: ");
                        String filePath = scanner.nextLine();
                        editor.openFile(filePath);
                        break;

                    case 2:
                        try {
                            editor.saveFile();
                            System.out.println("File saved successfully.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            editor.closeFile();
                            System.out.println("File closed successfully.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("Exiting application...");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Application terminated.");

    }
}
