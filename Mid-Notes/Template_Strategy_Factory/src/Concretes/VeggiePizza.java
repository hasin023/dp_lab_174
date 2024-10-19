package Concretes;

import Abstracts.*;
import Behaviours.*;

public class VeggiePizza extends Pizza {
    private ToppingStrategy toppingStrategy;
    private BakingStrategy bakingStrategy;

    public VeggiePizza(ToppingStrategy toppingStrategy, BakingStrategy bakingStrategy) {
        this.toppingStrategy = toppingStrategy;
        this.bakingStrategy = bakingStrategy;
    }

    @Override
    protected void addSauceAndToppings() {
        System.out.println("Adding pesto sauce...");
        toppingStrategy.addToppings();
    }

    @Override
    protected void bakePizza() {
        bakingStrategy.bake();
    }
}