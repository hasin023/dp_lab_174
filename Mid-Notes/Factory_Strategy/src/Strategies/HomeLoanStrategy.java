package Strategies;

import Behaviours.InterestStrategy;

public class HomeLoanStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double loanAmount) {
        return loanAmount * 0.3;
    }

}
