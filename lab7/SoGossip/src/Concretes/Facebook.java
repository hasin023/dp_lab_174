package Concretes;

import java.util.List;

import Behaviours.ISocials;

public class Facebook implements ISocials {
    @Override
    public void deleteNotification() {
        System.out.println("Deleting notification from Facebook");
    }

    @Override
    public List<String> getNotifications() {
        System.out.println("Getting notifications from Facebook");
        return List.of("FB 1", "FB 2", "FB 3");
    }

    @Override
    public void markAsRead() {
        System.out.println("Marking notification as read from Facebook");
    }

    @Override
    public void markAsUnread() {
        System.out.println("Marking notification as unread from Facebook");
    }

}
