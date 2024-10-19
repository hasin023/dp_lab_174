package Strategies;

import Behaviours.ToppingStrategy;

public class PepperoniTopping implements ToppingStrategy {
    @Override
    public void addToppings() {
        System.out.println("Adding pepperoni and cheese...");
    }
}