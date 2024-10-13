package Concretes;

import Abstracts.CompositeProduct;

public class Bundle1 extends CompositeProduct {
    public Bundle1() {
        super();
        addProduct(new Laptop("Laptop", 3.49, "High-performance laptop"));
        addProduct(new Mouse("Mouse", 1.49, "Ergonomic mouse"));
    }

    @Override
    public void getDescription() {
        System.out.println("Bundle 1 contains:");
        super.getDescription();
    }
}