import beverage.Espresso;
import beverage.interfaces.ICoffee;
import condiments.Cream;
import condiments.Milk;
import condiments.Sugar;

public class App {
    public static void main(String[] args) throws Exception {
        ICoffee espresso = new Espresso();
        espresso.add(new Milk(new Sugar(new Cream(null))));

        System.out.println(espresso.getDescription() + " $" + String.format("%.2f", espresso.getCost()));
    }
}
