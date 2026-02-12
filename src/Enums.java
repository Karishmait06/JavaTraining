enum TrafficLight {
    RED,
    YELLOW,
    GREEN
}

enum AccountType {
    SAVINGS(4.0),
    CURRENT(0.0),
    FD(6.5);

    private double interestRate;

    AccountType(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}


class BankAccount {

    private String holderName;
    private AccountType accountType;
    private double balance;

    BankAccount(String holderName, AccountType accountType, double balance, double interestRate) {
        this.holderName = holderName;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void showDetails() {
        System.out.println("Name: " + holderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + accountType.getInterestRate() + "%");
         System.out.println("-----------------------------");
    }
}



public class Enums {
    public static void main(String[] args) {

        //example 1
        TrafficLight signal = TrafficLight.RED;

        if (signal == TrafficLight.RED) {
            System.out.println("Stop!");
        } else if (signal == TrafficLight.YELLOW) {
            System.out.println("Get Ready!");
        } else if (signal == TrafficLight.GREEN) {
            System.out.println("Go!");
        }

    //example 2
        BankAccount acc1 = new BankAccount("Karishma", AccountType.SAVINGS, 5000, AccountType.SAVINGS.getInterestRate());
        BankAccount acc2 = new BankAccount("Luffy", AccountType.CURRENT, 12000, AccountType.CURRENT.getInterestRate());
        BankAccount acc3 = new BankAccount("Zoro", AccountType.FD, 100000, AccountType.FD.getInterestRate());

        acc1.showDetails();
        acc2.showDetails();
        acc3.showDetails();
    }
}
