package com.burmaguru.all_in_one.rentalsystem;

public class Customer {
    private final String customerId;
    private final String name;
    private double balance;

    public Customer(String customerId, String name, double initialBalance) {
        this.customerId = customerId;
        this.name = name;
        this.balance = initialBalance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void reduceBalance(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount reduced successfully. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}