package Concretes;

import Behaviours.INotify;

public class EmailNotify implements INotify {
    public void pushNotify(String uniqueId, String message) {
        System.out.println("Email sent to " + uniqueId + " with message: " + message);
    }
}
