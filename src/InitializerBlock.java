class BankAccount {

    // static variable
    static double interestRate;

    // instance variables
    String accountHolder;
    double balance;

    // Static initializer block (runs once)
    static {
        interestRate = 4.5;
        System.out.println("Static block: Interest rate initialized to " + interestRate + "%");
    }

    // Instance initializer block (runs for every object)
    {
        balance = 1000; // default opening balance
        System.out.println("Instance block: New account created with default balance");
    }

    // Constructor
    BankAccount(String name) {
        accountHolder = name;
        System.out.println("Constructor: Account holder = " + accountHolder);
    }

    void display() {
        System.out.println(accountHolder + " balance = " + balance);
    }

 
}
public class InitializerBlock {
     public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Rahul");
        System.out.println("-----");
        BankAccount a2 = new BankAccount("Priya");

        a1.display();
        a2.display();
    }
}
