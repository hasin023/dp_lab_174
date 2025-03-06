package commands;

import interfaces.ITransaction;
import concretes.Account;
import concretes.Transaction;

public class AccountCreateCommand implements ITransaction {
    private Account account;
    private String accountNumber;
    private double initialDeposit;

    public AccountCreateCommand(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.initialDeposit = initialDeposit;
    }

    @Override
    public void execute() {
        account = new Account(accountNumber, initialDeposit);
        account.transactionHistory.push(new Transaction("Account Created", initialDeposit, null, accountNumber));
    }
}
