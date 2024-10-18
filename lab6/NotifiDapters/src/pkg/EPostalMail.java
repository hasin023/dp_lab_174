package pkg;

public class EPostalMail {

    public void sendPostalMail(String uniqueId, String message, String PostalAddress, String PostalCode) {
        System.out.println("Postal mail sent to " + uniqueId + " with message: " + message + " to address: "
                + PostalAddress + " with postal code: " + PostalCode);
    }

    public String getPostalAddress() {
        return "Postal Address";
    }

    public String getPostalCode() {
        return "Postal Code";
    }
}
