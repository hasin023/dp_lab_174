package Facades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Behaviours.ISocials;
import Concretes.Facebook;
import Concretes.Instagram;

public class SocialMediaFacade {
    private Map<String, ISocials> platforms;

    public SocialMediaFacade() {
        platforms = new HashMap<>();

        platforms.put("Facebook", new Facebook());
        platforms.put("Instagram", new Instagram());
    }

    public void addSocialMediaPlatform(String platform, ISocials socialMedia) {
        platforms.put(platform, socialMedia);
    }

    public List<String> getAllNotifications() {
        List<String> notifications = new ArrayList<>();

        for (ISocials platform : platforms.values()) {
            notifications.addAll(platform.getNotifications());
        }

        return notifications;
    }

    public void markNotificationAsRead(String notificationId, String platform) {
        // Mark notification as read
    }

    public void markNotificationAsUnread(String notificationId, String platform) {
        // Mark notification as unread
    }

    public void deleteNotification(String notificationId, String platform) {
        // Delete notification
    }
}
