package com.inventory.backend.controller;

import com.inventory.backend.model.Item;
import com.inventory.backend.service.impl.HistoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/history")
public class HistoryController {
    private final HistoryServiceImpl historyService;

    @GetMapping("/list")
    public ResponseEntity<?> getHistories() {
        return ResponseEntity.ok(historyService.list());
    }
}
