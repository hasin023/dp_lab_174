package Adapters;

import Behaviours.INotify;
import pkg.EPostalMail;

public class EPostalAdapter implements INotify {
    EPostalMail ePostalMail = new EPostalMail();

    public void pushNotify(String uniqueId, String message) {
        ePostalMail.sendPostalMail(uniqueId, message, ePostalMail.getPostalCode(), ePostalMail.getPostalCode());
    }
}
