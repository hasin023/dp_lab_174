package Concretes;

import Abstracts.CompositeProduct;
import Behaviours.IProduct;

public class Bundle1 extends CompositeProduct {
    public Bundle1() {
        super("Bundle 1", 0.10);
        addProduct(new Laptop("Laptop", 999.99, "High-performance laptop"));
        addProduct(new Mouse("Mouse", 29.99, "Ergonomic mouse"));
    }

    @Override
    public void displayDetails() {
        System.out.println("Special Bundle: " + getName());
        for (IProduct product : products) {
            product.displayDetails();
        }
    }
}