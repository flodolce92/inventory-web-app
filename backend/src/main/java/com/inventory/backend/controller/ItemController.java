package com.inventory.backend.controller;

import com.inventory.backend.service.impl.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
