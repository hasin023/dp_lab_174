package Strategies;

import Behaviours.BakingStrategy;

public class FastBake implements BakingStrategy {
    @Override
    public void bake() {
        System.out.println("Baking at 500°F for 10 minutes...");
    }
}
