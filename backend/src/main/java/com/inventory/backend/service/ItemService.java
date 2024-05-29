package com.inventory.backend.service;

import com.inventory.backend.model.Item;

import java.util.Collection;

public interface ItemService {
    Item create(Item item);
    Collection<Item> list();
    Item get(Long id);
    Item update(Item item);
    Boolean delete(Long id);
    Collection<String> findDistinctCategories();
}
