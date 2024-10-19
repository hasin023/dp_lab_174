import Adapters.EPostalAdapter;
import Behaviours.INotify;
import Concretes.EmailNotify;
import Concretes.SMSNotify;
import Services.NotificationService;

public class App {
    public static void main(String[] args) throws Exception {
        NotificationService notificationService = new NotificationService();

        INotify email = new EmailNotify();
        INotify sms = new SMSNotify();
        INotify postalAdapter = new EPostalAdapter();

        String userId = "hasin023";
        String message = "Goodbye from Java";

        notificationService.SendNotification(postalAdapter, userId, message);
    }
}
