package Concretes;

import Behaviours.INotify;

public class SMSNotify implements INotify {
    public void pushNotify(String uniqueId, String message) {
        System.out.println("SMS sent to " + uniqueId + " with message: " + message);
    }
}
