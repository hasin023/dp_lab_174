package strategies;

import helpers.FileHandler;
import interfaces.IEncryption;

public class DESMethod implements IEncryption {

    @Override
    public String encrypt(String text) {
        FileHandler.ReadFile("Some path");
        FileHandler.WriteFile("Some path", "Some text");

        return "DES encrypted text";
    }

    @Override
    public String decrypt(String text) {
        FileHandler.ReadFile("Some path");
        FileHandler.WriteFile("Some path", "Some text");

        return "DES decrypted text";
    }

    @Override
    public String getEncryptionName() {
        return "DES";
    }

}
