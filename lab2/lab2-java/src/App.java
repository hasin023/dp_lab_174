import initializers.MiniUberAdmin;
import initializers.MiniUberDriver;
import initializers.MiniUberRider;

public class App {
        public static void main(String[] args) throws Exception {
                boolean session = true;

                while (session) {
                        System.out.println("Welcome to Mini Uber!");
                        System.out.println("1. Rider");
                        System.out.println("2. Driver");
                        System.out.println("3. Admin");
                        System.out.println("4. Exit");
                        System.out.print("Choose user type: ");
                        int choice = Integer.parseInt(System.console().readLine());

                        switch (choice) {
                                case 1:
                                        MiniUberRider riderInterface = new MiniUberRider();
                                        riderInterface.initialize();
                                        break;
                                case 2:
                                        MiniUberDriver driverInterface = new MiniUberDriver();
                                        driverInterface.initialize();
                                        break;
                                case 3:
                                        MiniUberAdmin adminInterface = new MiniUberAdmin();
                                        adminInterface.initialize();
                                        break;
                                case 4:
                                        session = false;
                                        break;
                                default:
                                        System.out.println("Invalid choice!");
                                        break;
                        }
                }
        }
}
