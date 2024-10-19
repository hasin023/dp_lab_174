package Services;

import Behaviours.IImageService;
import Concretes.BaseImageService;
import Decorators.CompressionDecorator;
import Decorators.ResizeDecorator;
import Decorators.VirusScanDecorator;

public class ChatImageService {

    public void processAndSendImage(String imagePath, String recipient) {
        IImageService service = new BaseImageService();
        service = new VirusScanDecorator(service);
        service = new ResizeDecorator(service);
        service = new CompressionDecorator(service); // Compression added here

        byte[] image = service.processImage(new byte[] {});
        service.sendImage(image, recipient);
    }

}
