public class App {
        public static void main(String[] args) throws Exception {
                StoreTreasureKey treasureKey1 = StoreTreasureKey.getInstance();
                treasureKey1.lockDoor();

                // Both references should point to the same instance.
                StoreTreasureKey treasureKey2 = StoreTreasureKey.getInstance();
                System.out.println(treasureKey1 == treasureKey2); // Output: true (Singleton)

                // Using the other singleton instance to unlock the door
                treasureKey2.unlockDoor();
        }
}
