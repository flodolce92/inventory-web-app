package com.inventory.backend.service.impl;

import com.inventory.backend.model.ItemOption;
import com.inventory.backend.repo.ItemOptionRepo;
import com.inventory.backend.service.ItemOptionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ItemOptionServiceImpl implements ItemOptionService {
    private final ItemOptionRepo itemOptionRepo;

    @Override
    public ItemOption create(ItemOption itemOption) {
        log.info("Creating item option for item: {}", itemOption.getItem().getName());
        return itemOptionRepo.save(itemOption);
    }

    @Override
    public Collection<ItemOption> list() {
        log.info("Fetching all item options");
        return itemOptionRepo.findAll();
    }

    @Override
    public ItemOption get(Long id) {
        log.info("Fetching item option with id: {}", id);
        return itemOptionRepo.findById(id).orElse(null);
    }

    @Override
    public ItemOption update(ItemOption itemOption) {
        log.info("Updating item option with id: {}", itemOption.getId());
        return itemOptionRepo.save(itemOption);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting item option with id: {}", id);
        return itemOptionRepo.findById(id).map(itemOption -> {
            itemOptionRepo.delete(itemOption);
            return true;
        }).orElse(false);
    }
}
