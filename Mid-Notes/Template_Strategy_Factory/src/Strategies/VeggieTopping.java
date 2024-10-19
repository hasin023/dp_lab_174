package Strategies;

import Behaviours.ToppingStrategy;

public class VeggieTopping implements ToppingStrategy {
    @Override
    public void addToppings() {
        System.out.println("Adding vegetables and mozzarella...");
    }
}