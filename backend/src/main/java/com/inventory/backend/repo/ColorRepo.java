package com.inventory.backend.repo;

import com.inventory.backend.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepo extends JpaRepository<Color, Long> {
}
