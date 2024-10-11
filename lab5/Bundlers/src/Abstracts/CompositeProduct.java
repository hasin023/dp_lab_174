package Abstracts;

import java.util.List;

import Behaviours.IProduct;

public abstract class CompositeProduct implements IProduct {
    protected List<SimpleProduct> products;

    public CompositeProduct(List<SimpleProduct> products) {
        this.products = products;
    }

    public abstract void getDescription();

    public abstract double calculatePrice();
}
