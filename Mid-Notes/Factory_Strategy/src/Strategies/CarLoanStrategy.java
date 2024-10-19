package Strategies;

import Behaviours.InterestStrategy;

public class CarLoanStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double loanAmount) {
        return loanAmount * 0.4;
    }

}
