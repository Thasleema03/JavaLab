package C01;

import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
        displayBalance();
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
        displayBalance();
    }

    // Display account information
    public void displayAccountInfo() {
        System.out.println("\n===== Account Details =====");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        displayBalance();
    }

    // Display balance
    private void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    // Main method to test the class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount("1234567890", "Anu", 1000);

        while (true) {
            System.out.println("\n**** Choose an operation ****");
            System.out.println("1. Display Account Info");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) { // Validate menu choice input
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    acc.displayAccountInfo();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    if (sc.hasNextDouble()) {
                        double depositAmount = sc.nextDouble();
                        acc.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        sc.next();
                    }
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    if (sc.hasNextDouble()) {
                        double withdrawAmount = sc.nextDouble();
                        acc.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        sc.next();
                    }
                    break;
                case 4:
                    System.out.println("Thank you! Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}

