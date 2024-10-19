package Concretes.Coffee;

import Behaviours.ICoffee;
import Behaviours.ICondiment;

public class Espresso implements ICoffee {
    private final ICondiment condiment;

    public Espresso(ICondiment condiment) {
        this.condiment = condiment;
    }

    @Override
    public String GetDescription() {
        return "Espresso" + (condiment != null ? " with " + condiment.GetDescription() : "");
    }

    @Override
    public double GetPrice() {
        return 1.1 + (condiment != null ? condiment.GetPrice() : 0);
    }
}