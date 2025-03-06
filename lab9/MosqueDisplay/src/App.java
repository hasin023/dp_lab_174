import mediators.ConcreteMediator;

public class App {
    public static void main(String[] args) throws Exception {
        ConcreteMediator mediator = new ConcreteMediator();
        mediator.UpdateTimeZone("Asia/Dhaka");
    }
}
