package com.inventory.backend.service.impl;

import com.inventory.backend.model.Color;
import com.inventory.backend.repo.ColorRepo;
import com.inventory.backend.service.ColorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ColorServiceImpl implements ColorService {
    private final ColorRepo colorRepo;

    @Override
    public Color create(Color color) {
        log.info("Creating color: {}", color.getName());
        return colorRepo.save(color);
    }

    @Override
    public Collection<Color> list() {
        log.info("Fetching all colors");
        return colorRepo.findAll();
    }

    @Override
    public Color get(Long id) {
        log.info("Fetching color with id: {}", id);
        return colorRepo.findById(id).orElse(null);
    }
}
