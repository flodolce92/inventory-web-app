package com.inventory.backend.service;

import com.inventory.backend.model.ItemOption;

import java.util.Collection;

public interface ItemOptionService {
    ItemOption create(ItemOption itemOption);
    Collection<ItemOption> list();
    ItemOption get(Long id);
    ItemOption update(ItemOption itemOption);
    Boolean delete(Long id);
}
