package com.inventory.leonardo.inventory.repo;

import com.inventory.leonardo.inventory.model.Operations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationsRepo extends JpaRepository<Operations, Integer> {
}

