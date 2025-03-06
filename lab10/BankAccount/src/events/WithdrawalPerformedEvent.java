package events;

import abstracts.Event;

public class WithdrawalPerformedEvent extends Event {
    private final String accountId;
    private final double amount;
    private final double updatedBalance;
    
    public WithdrawalPerformedEvent(String accountId, double amount, double updatedBalance) {
        super();
        this.accountId = accountId;
        this.amount = amount;
        this.updatedBalance = updatedBalance;
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public double getUpdatedBalance() {
        return updatedBalance;
    }
}
