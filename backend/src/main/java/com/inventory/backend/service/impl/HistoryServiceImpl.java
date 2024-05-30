package com.inventory.backend.service.impl;

import com.inventory.backend.model.History;
import com.inventory.backend.model.Item;
import com.inventory.backend.repo.HistoryRepo;
import com.inventory.backend.service.HistoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepo historyRepo;

    @Override
    public Collection<History> list() {
        log.info("Fetching all histories");
        return historyRepo.findAll();
    }
}
