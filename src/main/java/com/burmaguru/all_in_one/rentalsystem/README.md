# Rental System

## Overview

This Rental System is a Java-based application that manages the rental of cars and apartments. It demonstrates the use of object-oriented programming principles and design patterns to create a flexible and maintainable system.

## Features

- Manage rentable items (cars and apartments)
- Handle customer information and balances
- Rent and replace items
- Display available items and customer information
- Console-based user interface for easy interaction

## Project Structure

The project is organized into several key components:

- `RentalSystem`: Main class with the entry point
- `RentalFacade`: Provides a simplified interface to the system
- `RentalService`: Manages the core business logic
- `UserInterface`: Handles user interactions (currently console-based)
- `ItemRepository`: Manages rentable item data
- `CustomerRepository`: Manages customer data
- `RentableItem`: Abstract base class for rentable items
- `Car` and `Apartment`: Concrete implementations of rentable items
- `Customer`: Represents a customer in the system

## Design Patterns and Principles

This project implements several design patterns and principles:

- **Facade Pattern**: `RentalFacade` simplifies the interface to the complex subsystem
- **Repository Pattern**: `ItemRepository` and `CustomerRepository` abstract data access
- **Strategy Pattern**: `UserInterface` is an abstraction that can have different implementations
- **Dependency Inversion**: High-level modules depend on abstractions
- **Open/Closed Principle**: The system is open for extension but closed for modification
- **Single Responsibility Principle**: Each class has a single, well-defined responsibility

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor

### Running the Application

1. Clone the repository or download the source code
2. Open the project in your Java IDE
3. Locate the `RentalSystem` class and run its `main` method
4. Follow the on-screen prompts to interact with the system

## Usage

The system provides a menu-driven interface with the following options:

1. Go to Car Rental Page
2. Go to Apartment Rental Page
3. Show All Items
4. Show All Customers
5. Replace Items
6. Exit

Each option leads to sub-menus or actions related to managing rentals, viewing items, and handling customer information.

## Extending the System

To add new types of rentable items:

1. Create a new class that extends `RentableItem`
2. Implement the `displayDetails()` method
3. Update the `InMemoryItemRepository` to handle the new item type
4. Add appropriate menu options in the `ConsoleUserInterface`

## Contributing

Contributions to improve the system are welcome. Please follow these steps:

1. Fork the repository
2. Create a new branch for your feature
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).