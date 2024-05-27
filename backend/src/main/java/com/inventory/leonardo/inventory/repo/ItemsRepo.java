package com.inventory.leonardo.inventory.repo;

import com.inventory.leonardo.inventory.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ItemsRepo extends JpaRepository<Items, Integer> {


    void deleteItemsById(int id);

    Optional<Items> findItemsById(int id);
}
