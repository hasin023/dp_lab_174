package Abstracts;

import java.util.ArrayList;
import java.util.List;

import Behaviours.IProduct;

public abstract class CompositeProduct implements IProduct {
    protected List<IProduct> products;

    public CompositeProduct() {
        this.products = new ArrayList<>();
    }

    public void addProduct(IProduct product) {
        products.add(product);
    }

    public void removeProduct(IProduct product) {
        products.remove(product);
    }

    @Override
    public void getDescription() {
        for (IProduct product : products) {
            product.getDescription();
        }
    }

    @Override
    public double calculatePrice() {
        return products.stream()
                .mapToDouble(IProduct::calculatePrice)
                .sum();
    }
}
