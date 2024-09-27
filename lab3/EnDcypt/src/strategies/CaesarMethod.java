package strategies;

import helpers.FileHandler;
import interfaces.IEncryption;
import java.util.Scanner;

public class CaesarMethod implements IEncryption {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String encrypt(String data) {
        System.out.print("Enter the shift key (0-25) : ");
        int shiftKey = getValidShiftKey();

        StringBuilder result = new StringBuilder();
        for (char character : data.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) ((character - base + shiftKey) % 26 + base));
            } else {
                result.append(character);
            }
        }
        String encryptedData = result.toString();
        FileHandler.WriteFile("outputs/encryptResult.txt", encryptedData);
        return encryptedData;
    }

    @Override
    public String decrypt(String encryptedData) {
        System.out.print("Enter the shift key (0-25) : ");
        int shiftKey = getValidShiftKey();

        StringBuilder result = new StringBuilder();
        for (char character : encryptedData.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) ((character - base - shiftKey + 26) % 26 + base));
            } else {
                result.append(character);
            }
        }
        String decryptedData = result.toString();
        FileHandler.WriteFile("outputs/decryptResult.txt", decryptedData);
        return decryptedData;
    }

    private int getValidShiftKey() {
        while (true) {
            try {
                int key = Integer.parseInt(scanner.nextLine().trim());
                if (key >= 0 && key <= 25) {
                    return key;
                } else {
                    System.out.print("Invalid input. Please enter a number between 0 and 25: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    @Override
    public String getEncryptionName() {
        return "Caesar Cipher";
    }
}