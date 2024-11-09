package Concretes;

import java.util.List;

import Behaviours.ISocials;

public class Threads implements ISocials {
    @Override
    public void deleteNotification() {
        System.out.println("Deleting notification from Threads");
    }

    @Override
    public List<String> getNotifications() {
        System.out.println("Getting notifications from Threads");
        return List.of("Threads 1", "Threads 2", "Threads 3");
    }

    @Override
    public void markAsRead() {
        System.out.println("Marking notification as read from Threads");
    }

    @Override
    public void markAsUnread() {
        System.out.println("Marking notification as unread from Threads");
    }

}
