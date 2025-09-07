package CODSOFT;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("\n===   ATM MENU   ===");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println(".................");
    }

    public void run() {
        while (true) {
            showMenu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println(" Successfully withdrawn: $" + withdrawAmount);
                    } else {
                        System.out.println(" Withdrawal failed! Insufficient balance or invalid amount.");
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    if (account.deposit(depositAmount)) {
                        System.out.println(" Successfully deposited: $" + depositAmount);
                    } else {
                        System.out.println(" Deposit failed! Please enter a valid amount.");
                    }
                    break;

                case 3:
                    System.out.println(" Current Balance: $" + account.checkBalance());
                    break;

                case 4:
                    System.out.println(" Thank you for using the ATM!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice! Please try again.");
            }
        }
    }
}

public class Atm_Interface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); 
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}