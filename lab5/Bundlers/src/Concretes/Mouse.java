package Concretes;

import Behaviours.IProduct;

public class Mouse implements IProduct {
    private String name;
    private double price;
    private String description;

    public Mouse(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public void getDescription() {
        System.out.println("Mouse: " + description);
    }

    @Override
    public double calculatePrice() {
        return price;
    }
}
