package com.inventory.backend.service;

import com.inventory.backend.model.History;
import com.inventory.backend.model.Item;

import java.util.Collection;

public interface HistoryService {
    Collection<History> list();
}
