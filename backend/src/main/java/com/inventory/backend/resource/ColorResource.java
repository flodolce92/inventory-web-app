package com.inventory.backend.resource;

import com.inventory.backend.service.impl.ColorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/color")
public class ColorResource {
    private final ColorServiceImpl colorService;

    @GetMapping("/list")
    public ResponseEntity<?> getColors() {
        return ResponseEntity.ok(colorService.list());
    }
}
