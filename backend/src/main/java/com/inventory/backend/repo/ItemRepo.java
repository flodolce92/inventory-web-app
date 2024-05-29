package com.inventory.backend.repo;

import com.inventory.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long> {
    @Query("SELECT DISTINCT io.category FROM Item io")
    List<String> findDistinctCategories();
}
