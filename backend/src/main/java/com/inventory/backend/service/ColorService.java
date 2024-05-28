package com.inventory.backend.service;

import com.inventory.backend.model.Color;

import java.util.Collection;

public interface ColorService {
    Color create(Color color);
    Collection<Color> list();
    Color get(Long id);
}
