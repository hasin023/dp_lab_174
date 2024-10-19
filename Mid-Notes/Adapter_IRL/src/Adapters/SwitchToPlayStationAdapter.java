package Adapters;

import Behaviours.PlayStationController;
import Concretes.SwitchProController;

public class SwitchToPlayStationAdapter implements PlayStationController {
    private final SwitchProController switchController;

    public SwitchToPlayStationAdapter(SwitchProController switchController) {
        this.switchController = switchController;
    }

    @Override
    public void pressTriangle() {
        // Map X button to Triangle button
        switchController.pressX();
    }

    @Override
    public void pressSquare() {
        // Map Y button to Square button
        switchController.pressY();
    }

    @Override
    public void pressCross() {
        // Map B button to Cross button
        switchController.pressB();
    }

    @Override
    public void pressCircle() {
        // Map A button to Circle button
        switchController.pressA();
    }
}
