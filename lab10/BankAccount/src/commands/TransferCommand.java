package commands;

import interfaces.ITransaction;
import concretes.Account;
import concretes.Transaction;

public class TransferCommand implements ITransaction {
    private Account fromAccount;
    private Account toAccount;
    private double amount;

    public TransferCommand(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        fromAccount.transactionHistory.push(
                new Transaction("Transfer", amount, fromAccount.getAccountNumber(), toAccount.getAccountNumber()));
        toAccount.transactionHistory.push(
                new Transaction("Recieve", amount, fromAccount.getAccountNumber(), toAccount.getAccountNumber()));
    }

}
