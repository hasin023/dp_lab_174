package Concretes.Coffee;

import Behaviours.ICoffee;
import Behaviours.ICondiment;

public class Americano implements ICoffee {
    private final ICondiment condiment;

    public Americano(ICondiment condiment) {
        this.condiment = condiment;
    }

    @Override
    public String GetDescription() {
        return "Americano" + (condiment != null ? " with " + condiment.GetDescription() : "");
    }

    @Override
    public double GetPrice() {
        return 1.5 + (condiment != null ? condiment.GetPrice() : 0);
    }
}