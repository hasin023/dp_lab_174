package concretes;

import interfaces.ITransaction;
import java.time.LocalDateTime;

public class Transaction implements ITransaction {
    private String type;
    private double amount;
    private LocalDateTime timestamp;
    private String sourceAccountNumber;
    private String destinationAccountNumber;

    public Transaction(String type, double amount, String sourceAccountNumber, String destinationAccountNumber) {
        this.type = type;
        this.amount = amount;
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public void execute() {
        System.out.println("Executing: " + this);
    }

    public String toString() {
        return timestamp + " | " + type + " | " + amount +
                " | From: " + (sourceAccountNumber != null ? sourceAccountNumber : "N/A") +
                " | To: " + (destinationAccountNumber != null ? destinationAccountNumber : "N/A");
    }
}