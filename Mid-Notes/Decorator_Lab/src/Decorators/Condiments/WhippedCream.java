package Decorators.Condiments;

import Behaviours.ICondiment;

public class WhippedCream implements ICondiment {
    private final ICondiment condiment;

    public WhippedCream(ICondiment condiment) {
        this.condiment = condiment;
    }

    @Override
    public String GetDescription() {
        return "Whipped Cream" + (condiment != null ? " + " + condiment.GetDescription() : "");
    }

    @Override
    public double GetPrice() {
        return 0.7 + (condiment != null ? condiment.GetPrice() : 0);
    }
}