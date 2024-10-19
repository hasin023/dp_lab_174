package Factories;

import java.util.HashMap;
import java.util.Map;

import Behaviours.InterestStrategy;
import Strategies.*;

public class StrategyFactory {

    // Instance variable for storing strategies
    private final Map<String, InterestStrategy> strategies = new HashMap<>();

    // Constructor to initialize the strategies map
    public StrategyFactory() {
        strategies.put("personal", new PersonalLoanStrategy());
        strategies.put("home", new HomeLoanStrategy());
        strategies.put("car", new CarLoanStrategy());
    }

    // Instance method to retrieve the appropriate strategy
    public InterestStrategy getStrategy(String loanType) {
        return strategies.get(loanType);
    }
}