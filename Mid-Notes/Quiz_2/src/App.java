import Services.ChatImageService;
import Services.ProfileImageService;

public class App {
        public static void main(String[] args) throws Exception {
                ChatImageService chatService = new ChatImageService();
                chatService.processAndSendImage("chatImage.jpg", "recipient@example.com");

                // ProfileImageService without compression
                ProfileImageService profileService = new ProfileImageService();
                profileService.processAndSendImage("profileImage.jpg", "recipient@example.com");
        }

}
