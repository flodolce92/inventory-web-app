package com.inventory.backend.service.impl;

import com.inventory.backend.model.Item;
import com.inventory.backend.repo.ItemRepo;
import com.inventory.backend.service.ItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepo itemRepo;

    @Override
    public Item create(Item item) {
        log.info("Creating item: {}", item.getName());
        return itemRepo.save(item);
    }

    @Override
    public Collection<Item> list() {
        log.info("Fetching all items");
        return itemRepo.findAll();
    }

    @Override
    public Item get(Long id) {
        log.info("Fetching item with id: {}", id);
        return itemRepo.findById(id).orElse(null);
    }

    @Override
    public Item update(Item item) {
        log.info("Updating item with id: {}", item.getId());
        return itemRepo.save(item);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting item with id: {}", id);
        return itemRepo.findById(id).map(item -> {
            itemRepo.delete(item);
            return true;
        }).orElse(false);
    }

    @Override
    public Collection<String> findDistinctCategories() {
        log.info("Fetching distinct categories");
        return itemRepo.findDistinctCategories();
    }
}
