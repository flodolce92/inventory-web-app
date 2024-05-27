package com.inventory.leonardo.inventory.repo;

import com.inventory.leonardo.inventory.model.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizesRepo extends JpaRepository<Sizes, Integer> {
}

