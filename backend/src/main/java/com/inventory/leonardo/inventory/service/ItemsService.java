package com.inventory.leonardo.inventory.service;

import com.inventory.leonardo.inventory.exception.ItemsNotFoundException;
import com.inventory.leonardo.inventory.model.Items;
import com.inventory.leonardo.inventory.repo.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class ItemsService {
    private final ItemsRepo itemsRepo;

    @Autowired
    public ItemsService(ItemsRepo itemsRepo) {
        this.itemsRepo = itemsRepo;
    }

    //to create
    public Items addItem(Items item) {
        return itemsRepo.save(item);
    }

    //to read
    public List<Items> findAllItems() {
        return itemsRepo.findAll();
    }

    // Read (Get item by ID)
    public Items findItemById(int id) {
        return itemsRepo.findItemsById(id)
                .orElseThrow(() -> new ItemsNotFoundException( "Item by id: " + id + "not found."));
    }

    //to update
    public Items updateItems(Items item) {
        return itemsRepo.save(item);
    }

    //to delete
    public void deleteItems(int id) {
        itemsRepo.deleteItemsById(id);
    }

}
