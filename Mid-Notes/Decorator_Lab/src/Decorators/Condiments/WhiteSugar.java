package Decorators.Condiments;

import Behaviours.ICondiment;

public class WhiteSugar implements ICondiment {
    private final ICondiment condiment;

    public WhiteSugar(ICondiment condiment) {
        this.condiment = condiment;
    }

    @Override
    public String GetDescription() {
        return "White Sugar" + (condiment != null ? " + " + condiment.GetDescription() : "");
    }

    @Override
    public double GetPrice() {
        return 0.2 + (condiment != null ? condiment.GetPrice() : 0);
    }
}