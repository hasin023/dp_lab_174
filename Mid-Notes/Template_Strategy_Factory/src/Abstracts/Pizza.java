package Abstracts;

public abstract class Pizza {

    public final void cookPizza() {
        prepareDough();
        addSauceAndToppings();
        bakePizza();
    }

    // Step 1 is the same for all pizzas
    private void prepareDough() {
        System.out.println("Preparing pizza dough...");
    }

    // Steps 2 and 3 are customizable
    protected abstract void addSauceAndToppings();

    protected abstract void bakePizza();
}
