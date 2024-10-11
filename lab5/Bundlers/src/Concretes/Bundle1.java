package Concretes;

import java.util.List;

import Abstracts.CompositeProduct;
import Abstracts.SimpleProduct;

public class Bundle1 extends CompositeProduct {

    public Bundle1() {
        super(List.of(new Laptop("Laptop", 3.49, "LaptopD"),
                new Mouse("Mouse", 1.49, "MouseD")));
    }

    @Override
    public void getDescription() {
        for (SimpleProduct product : products) {
            product.getDescription();
        }
    }

    @Override
    public double calculatePrice() {
        double price = 0;
        for (SimpleProduct product : products) {
            price += product.calculatePrice();
        }
        return price;
    }

}
