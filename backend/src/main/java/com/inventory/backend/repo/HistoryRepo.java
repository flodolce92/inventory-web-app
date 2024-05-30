package com.inventory.backend.repo;

import com.inventory.backend.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<History, Long> {
}
