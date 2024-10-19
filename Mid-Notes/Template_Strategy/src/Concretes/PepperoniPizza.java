package Concretes;

import Abstracts.*;
import Behaviours.*;

public class PepperoniPizza extends Pizza {
    private ToppingStrategy toppingStrategy;
    private BakingStrategy bakingStrategy;

    public PepperoniPizza(ToppingStrategy toppingStrategy, BakingStrategy bakingStrategy) {
        this.toppingStrategy = toppingStrategy;
        this.bakingStrategy = bakingStrategy;
    }

    @Override
    protected void addSauceAndToppings() {
        System.out.println("Adding tomato sauce...");
        toppingStrategy.addToppings();
    }

    @Override
    protected void bakePizza() {
        bakingStrategy.bake();
    }
}
