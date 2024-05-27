package com.inventory.leonardo.inventory.service;

import com.inventory.leonardo.inventory.model.Sizes;
import com.inventory.leonardo.inventory.repo.SizesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizesService {
    private final SizesRepo sizesRepo;

    @Autowired
    public SizesService(SizesRepo sizesRepo) {
        this.sizesRepo = sizesRepo;
    }

    public List<Sizes> findAllSizes() {
        return sizesRepo.findAll();
    }

    public Sizes findSizeById(Integer id) {
        return sizesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Size not found"));
    }

    public Sizes addSize(Sizes size) {
        return sizesRepo.save(size);
    }

    public Sizes updateSize(Sizes size) {
        return sizesRepo.save(size);
    }

    public void deleteSize(Integer id) {
        sizesRepo.deleteById(id);
    }
}
