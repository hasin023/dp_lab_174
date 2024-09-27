import helpers.FileHandler;
import helpers.Initializer;
import interfaces.IEncryption;

public class App {
    public static void main(String[] args) throws Exception {
        boolean session = true;
        IEncryption encryption;

        while (session) {
            int choice = Initializer.encryptionChoice();
            encryption = Initializer.initializEncryption(choice);

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.println(encryption.getEncryptionName());
                    String textToEncrypt = FileHandler.ReadFile("inputs/toEncrypt.txt");
                    String encryptedText = encryption.encrypt(textToEncrypt);
                    System.out.println("Encrypted text: " + encryptedText);

                    break;

                case 4:
                case 5:
                case 6:
                    System.out.println(encryption.getEncryptionName());
                    String textToDecrypt = FileHandler.ReadFile("outputs/encryptResult.txt");
                    String decryptedText = encryption.decrypt(textToDecrypt);
                    System.out.println("Decrypted text: " + decryptedText);

                    break;
                case 7:
                    session = false;
                    System.out.println("\nKeep your secrets safe!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
                    break;
            }
        }
    }

}
