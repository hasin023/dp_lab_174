package concretes;

import interfaces.ITransaction;
import java.util.Stack;

public class Account {
    private double balance;
    private String accountNumber;
    public Stack<ITransaction> transactionHistory;

    public Account(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactionHistory = new Stack<>();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void transfer(Account destination, double amount) {
        this.withdraw(amount);
        destination.deposit(amount);
    }

    public void printStatement() {
        System.out.println("Bank Statement for Account: " + accountNumber);
        for (ITransaction t : transactionHistory) {
            System.out.println(t);
        }
        System.out.println("Current Balance: " + balance);
    }
}