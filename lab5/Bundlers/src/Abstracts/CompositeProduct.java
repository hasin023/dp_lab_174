package Abstracts;

import java.util.ArrayList;
import java.util.List;

import Behaviours.IProduct;

public abstract class CompositeProduct implements IProduct {
    protected String name;
    protected List<IProduct> products;
    protected double discountRate;

    public CompositeProduct(String name, double discountRate) {
        this.name = name;
        this.products = new ArrayList<>();
        this.discountRate = discountRate;
    }

    public void addProduct(IProduct product) {
        products.add(product);
    }

    public void removeProduct(IProduct product) {
        products.remove(product);
    }

    @Override
    public void displayDetails() {
        System.out.println("Bundle: " + name);
        for (IProduct product : products) {
            product.displayDetails();
        }
    }

    @Override
    public double calculatePrice() {
        double totalPrice = products.stream()
                .mapToDouble(IProduct::calculatePrice)
                .sum();
        return totalPrice * (1 - discountRate);
    }

    @Override
    public String getName() {
        return name;
    }
}
