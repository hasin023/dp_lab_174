package events;

import abstracts.Event;

public class TransferPerformedEvent extends Event {
    private final String sourceAccountId;
    private final String destinationAccountId;
    private final double amount;
    private final double sourceUpdatedBalance;
    private final double destinationUpdatedBalance;
    
    public TransferPerformedEvent(String sourceAccountId, String destinationAccountId, 
                                 double amount, double sourceUpdatedBalance, double destinationUpdatedBalance) {
        super();
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.amount = amount;
        this.sourceUpdatedBalance = sourceUpdatedBalance;
        this.destinationUpdatedBalance = destinationUpdatedBalance;
    }
    
    public String getSourceAccountId() {
        return sourceAccountId;
    }
    
    public String getDestinationAccountId() {
        return destinationAccountId;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public double getSourceUpdatedBalance() {
        return sourceUpdatedBalance;
    }
    
    public double getDestinationUpdatedBalance() {
        return destinationUpdatedBalance;
    }
}