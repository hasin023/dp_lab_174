import Abstracts.*;
import Behaviours.*;
import Concretes.*;
import Strategies.*;

public class App {
        public static void main(String[] args) throws Exception {
                ToppingStrategy pepperoniTopping = new PepperoniTopping();
                ToppingStrategy veggieTopping = new VeggieTopping();
                BakingStrategy fastBake = new FastBake();
                BakingStrategy slowBake = new SlowBake();

                // Create pizzas with specific strategies
                Pizza pepperoniPizza = new PepperoniPizza(pepperoniTopping, fastBake);
                Pizza veggiePizza = new VeggiePizza(veggieTopping, slowBake);

                // Cook pizzas
                System.out.println("Cooking Pepperoni Pizza:");
                pepperoniPizza.cookPizza();

                System.out.println("\nCooking Veggie Pizza:");
                veggiePizza.cookPizza();
        }

}
