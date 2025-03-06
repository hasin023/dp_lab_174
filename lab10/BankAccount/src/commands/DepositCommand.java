package commands;

import interfaces.ITransaction;
import concretes.Account;
import concretes.Transaction;

public class DepositCommand implements ITransaction {
    private Account account;
    private double amount;

    public DepositCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
        account.transactionHistory.push(new Transaction("Deposit", amount, null, account.getAccountNumber()));
    }
}
