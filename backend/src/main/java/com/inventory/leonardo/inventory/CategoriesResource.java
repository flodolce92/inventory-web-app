package com.inventory.leonardo.inventory;

import com.inventory.leonardo.inventory.model.Categories;
import com.inventory.leonardo.inventory.service.CategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoriesResource {
    private final CategoriesService categoriesService;

    public CategoriesResource(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    // Get all categories
    @GetMapping("/all")
    public ResponseEntity<List<Categories>> getAllCategories() {
        List<Categories> allCategories = categoriesService.findAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    // Get category by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable("id") Integer id) {
        Categories category = categoriesService.findCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    // Add new category
    @PostMapping("/add")
    public ResponseEntity<Categories> addCategory(@RequestBody Categories category) {
        Categories newCategory = categoriesService.addCategory(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    // Update category
    @PutMapping("/update")
    public ResponseEntity<Categories> updateCategory(@RequestBody Categories category) {
        Categories updateCategory = categoriesService.updateCategory(category);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    // Delete category
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id) {
        categoriesService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
