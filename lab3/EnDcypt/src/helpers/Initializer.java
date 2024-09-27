package helpers;

import interfaces.IEncryption;

public class Initializer {
    public static int encryptionChoice() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("1. AES Encryption");
        System.out.println("2. DES Encryption");
        System.out.println("3. Caesar Encryption");
        System.out.println("4. AES Decryption");
        System.out.println("5. DES Decryption");
        System.out.println("6. Caesar Decryption");
        System.out.println("7. Exit");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("\nChoose Operation: ");

        int choice = Integer.parseInt(System.console().readLine());

        return choice;
    }

    public static IEncryption initializEncryption(int choice) {
        IEncryption encryption = null;

        switch (choice) {
            case 1:
            case 4:
                encryption = new strategies.AESMethod();
                break;
            case 2:
            case 5:
                encryption = new strategies.DESMethod();
                break;
            case 3:
            case 6:
                encryption = new strategies.CaesarMethod();
                break;
            default:
                break;
        }

        return encryption;
    }
}
