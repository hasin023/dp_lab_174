package Services;

import Behaviours.IImageService;
import Concretes.BaseImageService;
import Decorators.ResizeDecorator;
import Decorators.VirusScanDecorator;

public class ProfileImageService {
    public void processAndSendImage(String imagePath, String recipient) {
        IImageService service = new BaseImageService();
        service = new VirusScanDecorator(service);
        service = new ResizeDecorator(service);
        // No compression decorator here

        byte[] image = service.processImage(new byte[] {});
        service.sendImage(image, recipient);
    }
}
