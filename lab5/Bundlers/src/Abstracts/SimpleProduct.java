package Abstracts;

import Behaviours.IProduct;

public abstract class SimpleProduct implements IProduct {
    protected String name;
    protected double price;
    protected String description;

    public SimpleProduct(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public abstract void getDescription();

    public abstract double calculatePrice();

}
