import Concretes.Loan;

public class App {
        public static void main(String[] args) throws Exception {
                Loan loan = new Loan(10000, "personal");
                System.out.println(loan.calculateInterest());

                Loan loan2 = new Loan(10000, "home");
                System.out.println(loan2.calculateInterest());

                Loan loan3 = new Loan(10000, "car");
                System.out.println(loan3.calculateInterest());
        }

}
