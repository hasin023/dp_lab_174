package Concretes;

import Behaviours.InterestStrategy;
import Factories.*;

public class Loan {
    private final double loanAmount;
    private final InterestStrategy interestStrategy;
    private StrategyFactory strategyFactory = new StrategyFactory();

    public Loan(double loanAmount, String loanType) {
        this.loanAmount = loanAmount;
        this.interestStrategy = strategyFactory.getStrategy(loanType);
    }

    public double calculateInterest() {
        return interestStrategy.calculateInterest(loanAmount);
    }
}
