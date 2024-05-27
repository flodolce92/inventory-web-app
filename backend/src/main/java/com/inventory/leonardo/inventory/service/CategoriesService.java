package com.inventory.leonardo.inventory.service;

import com.inventory.leonardo.inventory.model.Categories;
import com.inventory.leonardo.inventory.repo.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    private final CategoriesRepo categoriesRepo;

    @Autowired
    public CategoriesService(CategoriesRepo categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    public List<Categories> findAllCategories() {
        return categoriesRepo.findAll();
    }

    public Categories findCategoryById(Integer id) {
        return categoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Categories addCategory(Categories category) {
        return categoriesRepo.save(category);
    }

    public Categories updateCategory(Categories category) {
        return categoriesRepo.save(category);
    }

    public void deleteCategory(Integer id) {
        categoriesRepo.deleteById(id);
    }
}
