# Scenario

Let's imagine that you were hired by Nintendo to meet a very specific demand, they need PS5 players to be able to use the Nintendo Switch Pro controller to play games. Why? Nintendo was acquired by Sony.

Right, we know that they are different platforms, so we have a nintendo controller that can not adapt to the playstation console because it is incompatible. After all we can not directly change the control of a Nintendo, it would generate more work. But the two controls have some features in common. The controls have directionals, triggers and buttons that perform actions. But there is no Playstation driver that accepts the inputs from a Nintendo control. The standard adapter can solve this problem. We have a class that needs to be integrated into the system, and we can't change it directly. So we can create an adapter that will do this conversion. So when the user clicks on the X button on the switch pro, the adapter will convert to the triangle button on the Playstation and so on.

- X button on the switch pro -> Triangle button on the Playstation
- Y button on the switch pro -> Square button on the Playstation
- B button on the switch pro -> Cross button on the Playstation
- A button on the switch pro -> Circle button on the Playstation
