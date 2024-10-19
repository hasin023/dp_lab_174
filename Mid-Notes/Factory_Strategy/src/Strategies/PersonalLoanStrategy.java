package Strategies;

import Behaviours.InterestStrategy;

public class PersonalLoanStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double loanAmount) {
        return loanAmount * 0.1;
    }

}
