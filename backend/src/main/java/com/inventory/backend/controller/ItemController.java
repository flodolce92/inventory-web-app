package com.inventory.backend.controller;

import com.inventory.backend.model.Item;
import com.inventory.backend.service.impl.ItemServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {
    private final ItemServiceImpl itemService;

    @GetMapping("/list")
    public ResponseEntity<?> getItems() {
        return ResponseEntity.ok(itemService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.get(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody @Valid Item item) {
        return ResponseEntity.ok(itemService.create(item));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateItem(@RequestBody @Valid Item item) {
        return ResponseEntity.ok(itemService.update(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable Long id) {
        boolean isDeleted = itemService.delete(id);
        return ResponseEntity.ok(isDeleted);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(itemService.findDistinctCategories());
    }
}
