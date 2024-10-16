package com.burmaguru.all_in_one.rentalsystem;

public class RentalService {
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;

    public RentalService(ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    public void rentItem(String customerId, String itemId) {
        Customer customer = customerRepository.findById(customerId);
        RentableItem item = itemRepository.findById(itemId);

        if (customer != null && item != null && item.isAvailable()) {
            if (customer.getBalance() >= item.getRentalAmount()) {
                customer.reduceBalance(item.getRentalAmount());
                item.rentItem();
                System.out.println(customer.getName() + " rented a " + item.getItemName());
            } else {
                System.out.println("Insufficient balance to rent.");
            }
        } else {
            System.out.println("Unable to process rental.");
        }
    }

    public void replaceItem(String itemId) {
        RentableItem item = itemRepository.findById(itemId);
        if (item != null && !item.isAvailable()) {
            item.replaceItem();
            System.out.println(item.getItemName() + " with ID " + itemId + " has been replaced.");
        } else {
            System.out.println("Item not found or already available.");
        }
    }

    public void displayAvailableItems(String itemType) {
        itemRepository.findAllByType(itemType).stream()
                .filter(RentableItem::isAvailable)
                .forEach(RentableItem::displayDetails);
    }

    public void displayAllCustomers() {
        customerRepository.findAll().forEach(customer ->
                System.out.println("Customer ID: " + customer.getCustomerId() +
                        ", Name: " + customer.getName() +
                        ", Balance: $" + customer.getBalance()));
    }

    public void addItem(RentableItem item) {
        itemRepository.save(item);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}