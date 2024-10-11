package Concretes;

import Abstracts.SimpleProduct;

public class Mouse extends SimpleProduct {
    public Mouse(String name, double price, String description) {
        super(name, price, description);
    }

    public void getDescription() {
        System.out.println("Mouse");
    }

    public double calculatePrice() {
        return 1.49;
    }
}
