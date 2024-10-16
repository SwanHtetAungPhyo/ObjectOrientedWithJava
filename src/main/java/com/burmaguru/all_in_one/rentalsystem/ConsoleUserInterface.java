package com.burmaguru.all_in_one.rentalsystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleUserInterface implements UserInterface {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void start(RentalService rentalService) {
        int choice;
        do {
            displayMainMenu();
            choice = getIntInput();
            processMainMenuChoice(choice, rentalService);
        } while (choice != 6);
    }

    private void displayMainMenu() {
        System.out.println("\n* * * * * Welcome To Vinn's Rental System * * * * *");
        System.out.println("1. Go to Car Rental Page");
        System.out.println("2. Go to Apartment Rental Page");
        System.out.println("3. Show All Items");
        System.out.println("4. Show All Customers");
        System.out.println("5. Replace Items");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void processMainMenuChoice(int choice, RentalService rentalService) {
        switch (choice) {
            case 1:
                handleCarRental(rentalService);
                break;
            case 2:
                handleApartmentRental(rentalService);
                break;
            case 3:
                handleShowAllItems(rentalService);
                break;
            case 4:
                rentalService.displayAllCustomers();
                break;
            case 5:
                handleReplaceItem(rentalService);
                break;
            case 6:
                System.out.println("Thank you for using Vinn's Rental System. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void handleCarRental(RentalService rentalService) {
        System.out.println("\n* * * * * Car Rental Page * * * * *");
        System.out.println("1. Show Rentable Car List");
        System.out.println("2. Rent Car");
        System.out.println("3. Back");
        System.out.print("Enter your choice: ");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                rentalService.displayAvailableItems("car");
                break;
            case 2:
                rentItem(rentalService, "car");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void handleApartmentRental(RentalService rentalService) {
        System.out.println("\n* * * * * Apartment Rental Page * * * * *");
        System.out.println("1. Show Rentable Apartment List");
        System.out.println("2. Rent Apartment");
        System.out.println("3. Back");
        System.out.print("Enter your choice: ");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                rentalService.displayAvailableItems("apartment");
                break;
            case 2:
                rentItem(rentalService, "apartment");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void handleShowAllItems(RentalService rentalService) {
        System.out.println("\n1. Show all cars");
        System.out.println("2. Show all apartments");
        System.out.println("3. Back");
        System.out.print("Enter your choice: ");
        int choice = getIntInput();
        switch (choice) {
            case 1:
                rentalService.displayAvailableItems("car");
                break;
            case 2:
                rentalService.displayAvailableItems("apartment");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void handleReplaceItem(RentalService rentalService) {
        System.out.print("Enter the item ID to replace: ");
        String itemId = getStringInput();
        rentalService.replaceItem(itemId);
    }

    private void rentItem(RentalService rentalService, String itemType) {
        System.out.print("Enter customer ID: ");
        String customerId = getStringInput();
        System.out.print("Enter " + itemType + " ID to rent: ");
        String itemId = getStringInput();
        rentalService.rentItem(customerId, itemId);
    }

    private int getIntInput() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }

    private String getStringInput() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            System.out.println("Error reading input.");
            return "";
        }
    }
}