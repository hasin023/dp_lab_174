package Concretes;

import Behaviours.IProduct;

public class Laptop implements IProduct {
    private String name;
    private double price;
    private String description;

    public Laptop(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public void getDescription() {
        System.out.println("Laptop: " + description);
    }

    @Override
    public double calculatePrice() {
        return price;
    }
}
