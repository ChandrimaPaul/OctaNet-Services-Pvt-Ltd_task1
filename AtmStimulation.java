import java.util.ArrayList;
import java.util.Scanner;

public class AtmStimulation {
    private static final int INITIAL_PIN = 1234;
    private static int pin = INITIAL_PIN;
    private static double balance = 1000.0;
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawCash(scanner);
                    break;
                case 3:
                    depositCash(scanner);
                    break;
                case 4:
                    changePin(scanner);
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting ATM Simulator...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Welcome to the ATM Simulator!");
        System.out.println("Please select an option:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Change PIN");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void checkBalance() {
        System.out.println(" current balance is: $" + balance);
        transactionHistory.add("Balance Inquiry");
    }

    private static void withdrawCash(Scanner scanner) {
        System.out.print(" withdrawl amount : $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline character

        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("You have withdrawn $" + amount + ". Your new balance is: $" + balance);
            transactionHistory.add("Cash Withdrawal: $" + amount);
        }
    }

    private static void depositCash(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline character

        balance += amount;
        System.out.println("You have deposited $" + amount + ". Your new balance is: $" + balance);
        transactionHistory.add("Cash Deposit: $" + amount);
    }

    private static void changePin(Scanner scanner) {
        System.out.print("Enter your current PIN: ");
        int currentPin = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        if (currentPin == pin) {
            System.out.print("Enter your new PIN: ");
            int newPin = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            pin = newPin;
            System.out.println("Your PIN has been changed successfully.");
        } else {
            System.out.println("Incorrect PIN. Please try again.");
        }
    }

    private static void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }
}
