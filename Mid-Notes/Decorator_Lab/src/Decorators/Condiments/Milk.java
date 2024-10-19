package Decorators.Condiments;

import Behaviours.ICondiment;

public class Milk implements ICondiment {
    private final ICondiment condiment;

    public Milk(ICondiment condiment) {
        this.condiment = condiment;
    }

    @Override
    public String GetDescription() {
        return "Milk" + (condiment != null ? " + " + condiment.GetDescription() : "");
    }

    @Override
    public double GetPrice() {
        return 0.5 + (condiment != null ? condiment.GetPrice() : 0);
    }
}