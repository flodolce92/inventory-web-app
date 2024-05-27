package com.inventory.leonardo.inventory.repo;

import com.inventory.leonardo.inventory.model.ListTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListTransactionRepo extends JpaRepository<ListTransaction, Integer> {
}
