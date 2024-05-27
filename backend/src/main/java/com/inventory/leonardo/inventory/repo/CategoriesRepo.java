package com.inventory.leonardo.inventory.repo;

import com.inventory.leonardo.inventory.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepo extends JpaRepository<Categories, Integer> {
}
