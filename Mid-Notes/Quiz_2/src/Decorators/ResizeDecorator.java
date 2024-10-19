package Decorators;

import Abstracts.ImageServiceDecorator;
import Behaviours.IImageService;

public class ResizeDecorator extends ImageServiceDecorator {

    public ResizeDecorator(IImageService imageService) {
        super(imageService);
    }

    @Override
    public byte[] processImage(byte[] image) {
        image = super.processImage(image);
        System.out.println("Resizing image to 1:1 ratio...");
        return image;
    }
}