import Behaviours.ICoffee;
import Concretes.Coffee.Americano;
import Concretes.Coffee.Espresso;
import Decorators.Condiments.Milk;
import Decorators.Condiments.WhippedCream;
import Decorators.Condiments.WhiteSugar;

public class App {
        public static void main(String[] args) throws Exception {
                ICoffee americano = new Americano(new Milk(new WhippedCream(null)));
                System.out.println(americano.GetDescription());
                System.out.println(String.format("%.2f", americano.GetPrice()));

                ICoffee espresso = new Espresso(
                                new WhiteSugar(new Milk(new WhippedCream(new WhiteSugar(new WhiteSugar(null))))));
                System.out.println(espresso.GetDescription());
                System.out.println(String.format("%.2f", espresso.GetPrice()));
        }
}