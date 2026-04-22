import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(0);
        System.out.print("Enter the amount to Deposit: ");
        double deposit = sc.nextDouble();
        account.deposit(deposit);
        System.out.print("Enter the amount to wirhdraw: ");
        double withdraw = sc.nextDouble();
        account.withdraw(withdraw);
        System.out.println("Current balance: " + account.getBalance());
        sc.close();
    }
}