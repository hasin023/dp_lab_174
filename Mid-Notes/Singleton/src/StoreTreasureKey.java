import Behaviours.IKey;

public class StoreTreasureKey implements IKey {
    private static StoreTreasureKey instance;

    // Encapsulation: Private constructor to prevent instantiation from outside.
    private StoreTreasureKey() {
    }

    // Singleton Access: Static method to get the single instance of the class.
    public static StoreTreasureKey getInstance() {
        if (instance == null) {
            // Lazy initialization: Creating the instance only when needed.
            instance = new StoreTreasureKey();
        }

        // Return the single instance of the class.
        return instance;
    }

    // Behavior of unlocking the door
    @Override
    public void unlockDoor() {
        System.out.println("The store's treasure door is unlocked.");
    }

    // Behavior of locking the door
    @Override
    public void lockDoor() {
        System.out.println("The store's treasure door is locked.");
    }
}
