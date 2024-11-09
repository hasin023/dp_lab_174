package Behaviours;

import java.util.List;

public interface ISocials {
    List<String> getNotifications();

    void markAsRead();

    void markAsUnread();

    void deleteNotification();
}
