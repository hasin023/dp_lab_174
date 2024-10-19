package Services;

import Behaviours.INotify;

public class NotificationService {
    public void SendNotification(INotify notifier, String uniqueId, String message) {
        notifier.pushNotify(uniqueId, message);
    }
}
