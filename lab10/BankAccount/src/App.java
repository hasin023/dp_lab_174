import commands.AccountCreateCommand;

public class App {
    public static void main(String[] args) throws Exception {
        AccountCreateCommand accountCreateCommand = new AccountCreateCommand("12345", 1000);
        accountCreateCommand.execute();

    }
}
