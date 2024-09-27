package strategies;

import helpers.FileHandler;
import interfaces.IEncryption;

public class CaesarMethod implements IEncryption {

    private int shiftValue;

    public int getShiftValue() {
        return shiftValue;
    }

    public void setShiftValue(int shiftValue) {
        this.shiftValue = shiftValue;
    }

    @Override
    public String encrypt(String text) {
        FileHandler.ReadFile("Some path");
        FileHandler.WriteFile("Some path", "Some text");

        return "Caesar encrypted text";
    }

    @Override
    public String decrypt(String text) {
        FileHandler.ReadFile("Some path");
        FileHandler.WriteFile("Some path", "Some text");

        return "Caesar decrypted text";
    }

    @Override
    public String getEncryptionName() {
        return "Caesar";
    }

}
