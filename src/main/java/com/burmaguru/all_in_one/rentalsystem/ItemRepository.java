package com.burmaguru.all_in_one.rentalsystem;

import java.util.List;

public interface ItemRepository {
    RentableItem findById(String id);
    void save(RentableItem item);
    List<RentableItem> findAllByType(String type);
}