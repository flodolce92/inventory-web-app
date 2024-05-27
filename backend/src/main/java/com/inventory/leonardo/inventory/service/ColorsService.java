package com.inventory.leonardo.inventory.service;

import com.inventory.leonardo.inventory.model.Colors;
import com.inventory.leonardo.inventory.repo.ColorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorsService {
    private final ColorsRepo colorsRepo;

    @Autowired
    public ColorsService(ColorsRepo colorsRepo) {
        this.colorsRepo = colorsRepo;
    }

    public List<Colors> findAllColors() {
        return colorsRepo.findAll();
    }

    public Colors findColorById(Integer id) {
        return colorsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Color not found"));
    }

    public Colors addColor(Colors color) {
        return colorsRepo.save(color);
    }

    public Colors updateColor(Colors color) {
        return colorsRepo.save(color);
    }

    public void deleteColor(Integer id) {
        colorsRepo.deleteById(id);
    }
}
