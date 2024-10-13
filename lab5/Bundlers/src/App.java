import Abstracts.CompositeProduct;
import Behaviours.IProduct;
import Concretes.Bundle1;
import Concretes.SimpleProduct;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleProduct phone = new SimpleProduct("Phone", 599.99, "Latest smartphone");
        SimpleProduct headphones = new SimpleProduct("Headphones", 199.99, "Noise-cancelling headphones");

        // Create Bundle1
        Bundle1 bundle1 = new Bundle1();

        // Create another composite bundle
        CompositeProduct megaBundle = new CompositeProduct("Mega Tech Bundle", 0.15) {
            @Override
            public String getName() {
                return name;
            }
        };
        megaBundle.addProduct(bundle1);
        megaBundle.addProduct(phone);
        megaBundle.addProduct(headphones);

        // Display all product information and calculate total price
        displayProductInfoAndPrice(megaBundle);
    }

    public static void displayProductInfoAndPrice(IProduct product) {
        System.out.println("Product Information:");
        product.displayDetails();
        System.out.println("\nTotal Price: $" + String.format("%.2f", product.calculatePrice()));
    }
}
