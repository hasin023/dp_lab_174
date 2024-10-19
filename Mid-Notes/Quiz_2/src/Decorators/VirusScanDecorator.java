package Decorators;

import Abstracts.ImageServiceDecorator;
import Behaviours.IImageService;

public class VirusScanDecorator extends ImageServiceDecorator {
    public VirusScanDecorator(IImageService imageService) {
        super(imageService);
    }

    @Override
    public byte[] processImage(byte[] image) {
        image = super.processImage(image);
        System.out.println("Scanning image for viruses...");
        return image;
    }
}
