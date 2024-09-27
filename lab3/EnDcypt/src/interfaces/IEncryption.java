package interfaces;

public interface IEncryption {

    public String encrypt(String text);

    public String decrypt(String text);

    public String getEncryptionName();
}
