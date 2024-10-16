package com.burmaguru.all_in_one.rentalsystem;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerRepository implements CustomerRepository {
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public Customer findById(String id) {
        return customers.stream()
                .filter(customer -> customer.getCustomerId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }
}