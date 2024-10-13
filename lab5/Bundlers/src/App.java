import Concretes.Bundle1;

public class App {
    public static void main(String[] args) throws Exception {
        Bundle1 bundle1 = new Bundle1();
        bundle1.getDescription();
        System.out.println("Total Price: $" + String.format("%.2f", bundle1.calculatePrice()));
    }
}
