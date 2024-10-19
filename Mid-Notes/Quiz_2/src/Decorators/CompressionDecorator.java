package Decorators;

import Abstracts.ImageServiceDecorator;
import Behaviours.IImageService;

public class CompressionDecorator extends ImageServiceDecorator {

    public CompressionDecorator(IImageService imageService) {
        super(imageService);
    }

    @Override
    public byte[] processImage(byte[] image) {
        image = super.processImage(image);
        System.out.println("Compressing image...");
        return image;
    }
}