package Concretes;

import Behaviours.IImageService;

public class BaseImageService implements IImageService {

    @Override
    public byte[] processImage(byte[] image) {
        System.out.println("Reading image from file...");
        return image;
    }

    @Override
    public void sendImage(byte[] image, String recipient) {
        System.out.println("Sending image to " + recipient + "...");
    }
}