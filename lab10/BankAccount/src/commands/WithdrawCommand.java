package commands;

import interfaces.ITransaction;
import concretes.Account;
import concretes.Transaction;

public class WithdrawCommand implements ITransaction {
    private Account account;
    private double amount;

    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
        account.transactionHistory.push(new Transaction("Withdraw", amount, account.getAccountNumber(), null));
    }
}