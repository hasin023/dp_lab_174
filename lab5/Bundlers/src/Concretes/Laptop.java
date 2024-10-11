package Concretes;

import Abstracts.SimpleProduct;

public class Laptop extends SimpleProduct {
    public Laptop(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void getDescription() {
        System.out.println("Laptop");
    }

    @Override
    public double calculatePrice() {
        return 3.00;
    }
}
