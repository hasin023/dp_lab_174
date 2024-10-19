package Abstracts;

import Behaviours.IImageService;

public abstract class ImageServiceDecorator implements IImageService {

    protected IImageService wrappedImageService;

    public ImageServiceDecorator(IImageService imageService) {
        this.wrappedImageService = imageService;
    }

    @Override
    public byte[] processImage(byte[] image) {
        return wrappedImageService.processImage(image);
    }

    @Override
    public void sendImage(byte[] image, String recipient) {
        wrappedImageService.sendImage(image, recipient);
    }
}