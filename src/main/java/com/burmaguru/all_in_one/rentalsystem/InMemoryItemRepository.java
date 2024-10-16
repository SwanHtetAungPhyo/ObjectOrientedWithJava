package com.burmaguru.all_in_one.rentalsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryItemRepository implements ItemRepository {
    private final List<RentableItem> items = new ArrayList<>();

    @Override
    public RentableItem findById(String id) {
        return items.stream()
                .filter(item -> item.getItemId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(RentableItem item) {
        items.add(item);
    }

    @Override
    public List<RentableItem> findAllByType(String type) {
        return items.stream()
                .filter(item -> (type.equals("car") && item instanceof Car) ||
                                (type.equals("apartment") && item instanceof Apartment))
                .collect(Collectors.toList());
    }
}