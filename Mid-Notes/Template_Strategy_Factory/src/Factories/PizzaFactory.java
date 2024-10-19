package Factories;

import Abstracts.*;
import Behaviours.*;
import Concretes.*;
import Strategies.*;

// Updated Factory class to create pizzas
public class PizzaFactory {

    public static Pizza createPizza(String type) {
        ToppingStrategy toppingStrategy;
        BakingStrategy bakingStrategy;

        switch (type.toLowerCase()) {
            case "pepperoni":
                // Use the pepperoni topping strategy and fast bake strategy
                toppingStrategy = new PepperoniTopping();
                bakingStrategy = new FastBake();
                return new PepperoniPizza(toppingStrategy, bakingStrategy);

            case "veggie":
                // Use the veggie topping strategy and slow bake strategy
                toppingStrategy = new VeggieTopping();
                bakingStrategy = new SlowBake();
                return new VeggiePizza(toppingStrategy, bakingStrategy);

            // Additional pizza types can be added here
            default:
                throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
    }
}
