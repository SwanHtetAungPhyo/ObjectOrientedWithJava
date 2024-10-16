package com.burmaguru.all_in_one.rentalsystem;

import java.util.List;

public interface CustomerRepository {
    Customer findById(String id);
    void save(Customer customer);
    List<Customer> findAll();
}