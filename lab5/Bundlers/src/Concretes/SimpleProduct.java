package Concretes;

import Behaviours.IProduct;

public class SimpleProduct implements IProduct {
    private String name;
    private double price;
    private String description;

    public SimpleProduct(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public void displayDetails() {
        System.out.println("  - " + name + ": $" + String.format("%.2f", price) + " - " + description);
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}