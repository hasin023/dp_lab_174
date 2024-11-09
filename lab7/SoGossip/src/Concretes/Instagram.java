package Concretes;

import java.util.List;

import Behaviours.ISocials;

public class Instagram implements ISocials {
    @Override
    public void deleteNotification() {
        System.out.println("Deleting notification from Instagram");
    }

    @Override
    public List<String> getNotifications() {
        System.out.println("Getting notifications from Instagram");
        return List.of("IG 1", "IG 2", "IG 3");
    }

    @Override
    public void markAsRead() {
        System.out.println("Marking notification as read from Instagram");
    }

    @Override
    public void markAsUnread() {
        System.out.println("Marking notification as unread from Instagram");
    }

}
