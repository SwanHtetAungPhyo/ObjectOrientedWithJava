package com.burmaguru.all_in_one.rentalsystem;

public class Apartment extends RentableItem {
    private final int numberOfRooms;
    private final boolean furnished;

    public Apartment(String itemId, String itemName, double rentalAmount, int numberOfRooms, boolean furnished) {
        super(itemId, itemName, rentalAmount);
        this.numberOfRooms = numberOfRooms;
        this.furnished = furnished;
    }

    @Override
    public void displayDetails() {
        System.out.println("Apartment Details - ID: " + getItemId() + ", Rooms: " + numberOfRooms +
                ", Furnished: " + furnished + ", Rental Amount: " + rentalAmount +
                ", Availability: " + isAvailable());
    }
}