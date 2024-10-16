package com.burmaguru.all_in_one.rentalsystem;

public class Car extends RentableItem {
    private final String brand;
    private final String model;

    public Car(String itemId, String itemName, double rentalAmount, String brand, String model) {
        super(itemId, itemName, rentalAmount);
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details - ID: " + getItemId() + ", Brand: " + brand +
                ", Model: " + model + ", Rental Amount: " + rentalAmount +
                ", Availability: " + isAvailable());
    }
}