package events;

import abstracts.Event;

public class AccountCreatedEvent extends Event {
    private final String accountId;
    private final double initialBalance;
    
    public AccountCreatedEvent(String accountId, double initialBalance) {
        super();
        this.accountId = accountId;
        this.initialBalance = initialBalance;
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public double getInitialBalance() {
        return initialBalance;
    }
}