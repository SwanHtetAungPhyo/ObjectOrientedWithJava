package com.burmaguru.all_in_one.rentalsystem;

public abstract class RentableItem {
    private final String itemId;
    private final String itemName;
    protected final double rentalAmount;
    private boolean available;

    public RentableItem(String itemId, String itemName, double rentalAmount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.rentalAmount = rentalAmount;
        this.available = true;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rentItem() {
        if (available) {
            available = false;
            System.out.println(itemName + " rented successfully.");
        } else {
            System.out.println(itemName + " is not available for rent.");
        }
    }

    public void replaceItem() {
        available = true;
        System.out.println(itemName + " replaced successfully.");
    }

    public abstract void displayDetails();
}