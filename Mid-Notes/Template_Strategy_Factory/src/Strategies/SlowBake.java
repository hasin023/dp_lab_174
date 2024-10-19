package Strategies;

import Behaviours.BakingStrategy;

public class SlowBake implements BakingStrategy {
    @Override
    public void bake() {
        System.out.println("Baking at 350°F for 20 minutes...");
    }
}
