import Abstracts.*;
import Factories.*;

public class App {
        public static void main(String[] args) throws Exception {
                Pizza pepperoniPizza = PizzaFactory.createPizza("pepperoni");
                Pizza veggiePizza = PizzaFactory.createPizza("veggie");

                // Cook pizzas
                System.out.println("Cooking Pepperoni Pizza:");
                pepperoniPizza.cookPizza();

                System.out.println("\nCooking Veggie Pizza:");
                veggiePizza.cookPizza();
        }
}
