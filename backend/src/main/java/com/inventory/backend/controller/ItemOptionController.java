package com.inventory.backend.controller;

import com.inventory.backend.service.impl.ItemOptionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/item-option")
public class ItemOptionController {
    private final ItemOptionServiceImpl itemOptionService;

    @GetMapping("/list")
    public ResponseEntity<?> getItemOptions() {
        return ResponseEntity.ok(itemOptionService.list());
    }
}
