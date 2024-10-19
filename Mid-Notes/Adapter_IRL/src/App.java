import Adapters.SwitchToPlayStationAdapter;
import Behaviours.PlayStationController;
import Concretes.SwitchProController;

public class App {
        public static void main(String[] args) throws Exception {
                SwitchProController switchProController = new SwitchProController();

                // Use the adapter to translate Switch inputs to PlayStation inputs
                PlayStationController playStationController = new SwitchToPlayStationAdapter(switchProController);

                playStationController.pressTriangle(); // Switch X button pressed
                playStationController.pressSquare(); // Switch Y button pressed
                playStationController.pressCross(); // Switch B button pressed
                playStationController.pressCircle(); // Switch A button pressed
        }
}
