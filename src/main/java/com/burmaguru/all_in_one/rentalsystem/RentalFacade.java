package com.burmaguru.all_in_one.rentalsystem;

public class RentalFacade {
    private final RentalService rentalService;
    private final UserInterface userInterface;

    public RentalFacade() {
        ItemRepository itemRepository = new InMemoryItemRepository();
        CustomerRepository customerRepository = new InMemoryCustomerRepository();
        this.rentalService = new RentalService(itemRepository, customerRepository);
        this.userInterface = new ConsoleUserInterface();
    }

    public void start() {
        initializeData();
        userInterface.start(rentalService);
    }

    private void initializeData() {
        rentalService.addItem(new Car("C001", "Honda Civic", 500.0, "Honda", "Civic"));
        rentalService.addItem(new Car("C002", "Honda Accord", 600.0, "Honda", "Accord"));
        rentalService.addItem(new Apartment("A001", "Luxury Apartment", 1200.0, 3, true));
        rentalService.addItem(new Apartment("A002", "Standard Apartment", 800.0, 2, false));
        rentalService.addCustomer(new Customer("CUS001", "Alvin", 1000.0));
        rentalService.addCustomer(new Customer("CUS002", "Bunny", 1500.0));
    }
}