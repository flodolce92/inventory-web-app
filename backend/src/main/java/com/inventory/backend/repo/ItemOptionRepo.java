package com.inventory.backend.repo;

import com.inventory.backend.model.ItemOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemOptionRepo extends JpaRepository<ItemOption, Long> {
    @Query("SELECT DISTINCT io.color FROM ItemOption io")
    List<String> findDistinctColors();

    @Query("SELECT DISTINCT io.size FROM ItemOption io")
    List<String> findDistinctSizes();
}
