import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayOptions() {
        System.out.println("ATM Interface:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("0. Exit");
    }

    public void processTransaction(int option, double amount) {
        switch (option) {
            case 1:
                withdraw(amount);
                break;
            case 2:
                deposit(amount);
                break;
            case 3:
                checkBalance();
                break;
            case 0:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
        }
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Updated balance: $" + userAccount.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + userAccount.getBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a user's bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM instance connected to the user's account
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display ATM options
            atm.displayOptions();

            // Get user input
            System.out.print("Enter option: ");
            int option = scanner.nextInt();

            if (option == 0) {
                break;
            }

            // Validate user input and process the transaction
            if (option >= 1 && option <= 3) {
                System.out.print("Enter amount: $");
                double amount = scanner.nextDouble();

                if (amount < 0) {
                    System.out.println("Invalid amount. Please enter a positive value.");
                    continue;
                }

                atm.processTransaction(option, amount);
            } else {
                System.out.println("Invalid option. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}
