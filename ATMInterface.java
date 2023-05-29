import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

class Account {
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account(double initialBalance) {
        balance = initialBalance;
        transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
    /*public void viewBalance() {
        System.out.println(balance);
    }*/
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("$" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            System.out.println("$" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add(new Transaction("Transfer", amount));
            System.out.println("$" + amount + " transferred successfully to recipient's account.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void showMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. View Transaction History");
        System.out.println("2. Current Balance");
        System.out.println("3. Withdraw");
        System.out.println("4. Deposit");
        System.out.println("5. Transfer");
        System.out.println("6. Quit");
    }

    public void performOperation(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                viewTransactionHistory();
                break;
            case 2:
                //viewBalance();
            case 3:
                withdraw(scanner);
                break;
            case 4:
                deposit(scanner);
                break;
            case 5:
                transfer(scanner);
                break;
            case 6:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }



    public void viewTransactionHistory() {
        ArrayList<Transaction> transactionHistory = account.getTransactionHistory();
        System.out.println("\nTransaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions to display.");
        } else {
            for (Transaction transaction : transactionHistory) {
                System.out.println(transaction.getType() + ": $" + transaction.getAmount());
            }
        }
    }

    public void withdraw(Scanner scanner) {
        System.out.print("\nEnter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public void deposit(Scanner scanner) {
        System.out.print("\nEnter the amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    public void transfer(Scanner scanner) {
        System.out.print("\nEnter the recipient's account number: ");
        int recipientAccountNumber = scanner.nextInt();
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();

        // In a real system, you would need to validate the recipient's account number.
        // For simplicity, let's assume the recipient's account is the same as the current account.
        Account recipientAccount = account;

        account.transfer(recipientAccount, amount);
    }
}

    class ATMInterfaces{
    public static void main(String[] args) {
        Account account = new Account(1000.0);
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        // In a real system, you would need to validate the user ID and PIN against a database of users.
        // For simplicity, let's assume the user ID and PIN are valid.
        System.out.println("Authentication successful.");

        while (true) {
            atm.showMenu();
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            atm.performOperation(choice, scanner);
        }
    }
}
