package Behaviours;

public interface IImageService {
    byte[] processImage(byte[] image);

    void sendImage(byte[] image, String recipient);
}