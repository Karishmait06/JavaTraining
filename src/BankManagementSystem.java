/*
Design a console-based Java application to manage bank accounts. The system should allow users to:
Create new accounts (Savings or Current)
Deposit money
Withdraw money
Check account balance
Display all accounts
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


interface Transactable {
    void deposit(double amt);
    boolean withdraw(double amt);
}

abstract class Account implements Transactable{
    long accNumber;
    String holderName;
    double balance;

    Account(long accNumber, String holderName, double balance) {
        this.accNumber = accNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }
    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        return "Account No: " + accNumber + ", Name: " + holderName + ", Balance: ₹" + balance;
    }

//    abstract boolean withdraw(double amt);

}

class SavingsAccount extends Account implements Transactable {
    SavingsAccount(long accNumber, String holderName, double balance) {
        super(accNumber, holderName, balance);
    }
    @Override
    public boolean withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            return true;
        }
        return false;
    }

}

class CurrentAccount extends Account  {

    float overdraftLimit = 50000f;

    CurrentAccount(long accNumber, String holderName, double balance) {
        super(accNumber, holderName, balance);
    }

    @Override
    public boolean withdraw(double amt) {
        if (amt <= balance + overdraftLimit) {
            balance -= amt;
            return true;
        }
        return false;
    }

}

class BankManager {
    private final Map<Long, Account> accounts = new HashMap<>();
    private long nextAccountNumber = 1000;

    void createAccount(String name, double initialDeposit, String accountType) {
        Account account;
        long accountNumber = ++nextAccountNumber;
        if (accountType.equalsIgnoreCase("savings")) {
            account = new SavingsAccount(accountNumber, name, initialDeposit);
        } else {
            account = new CurrentcreateAccountAccount(accountNumber, name, initialDeposit);
        }
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully!");
        System.out.println(account);
    }

    void deposit(long accNo, double amt) {
        Account account = accounts.get(accNo);
        if(account != null){
            account.deposit(amt);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    void withdraw(long accNo, double amt) {
        Account account = accounts.get(accNo);
        if(account != null) {
            if(account.withdraw(amt)){
                System.out.println("Withdraw successful.");
            } else {
                System.out.println("Withdraw failed.");
            }

        } else {
            System.out.println("Account not found");
        }
    }

    void checkBalance(long accNo) {
        Account account = accounts.get(accNo);
        if(account != null) {
            System.out.printf("Balance: ₹%.2f%n", account.getBalance());
        } else {
            System.out.println("Account not found");
        }

    }

    void displayAllAccount() {
        if(accounts.isEmpty()) {
            System.out.println("No accounts found");
            return;
        } else {
            for(Account acc : accounts.values()) {
                System.out.println(acc);
            }
        }
    }
}



;
public class BankManagementSystem {
    public static void main(String[] args) {
    BankManager manager = new BankManager();
    Scanner sc = new Scanner(System.in);

    while(true) {
        System.out.println("===Bank Menu===");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Display All Accounts");
        System.out.println("6. Exit");

        int choice;
        try{
            choice = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter input from 1 - 6");
            continue;
        }

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Account Holder Name : ");
                String name = sc.nextLine();
                System.out.print("Enter Initial Deposit : ");
                double initialDeposit = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter Account Type : ");
                String accountType = sc.nextLine();
                manager.createAccount(name, initialDeposit, accountType);
            }
            case 2 -> {
                System.out.print("Enter Account Number : ");
                long accNo = sc.nextLong();
                sc.nextLine();
                System.out.print("Enter Amount to Deposit : ");
                double amount = sc.nextDouble();
                sc.nextLine();
                manager.deposit(accNo, amount);
            }
            case 3 -> {
                System.out.print("Enter Account Number : ");
                long accNo = sc.nextLong();
                sc.nextLine();
                System.out.print("Enter Amount to Withdraw : ");
                double amount = sc.nextDouble();
                sc.nextLine();
                manager.withdraw(accNo, amount);
            }
            case 4 -> {
                System.out.print("Enter Account Number : ");
                long accNo = sc.nextLong();
                sc.nextLine();
                manager.checkBalance(accNo);
            }
            case 5 -> manager.displayAllAccount();
            case 6 -> {
                System.out.println("Thank you for visiting us!");
                sc.close();
                return;
            }
            default -> System.out.println("Invalid Input! Please try again");
        }
    }
    }
}
