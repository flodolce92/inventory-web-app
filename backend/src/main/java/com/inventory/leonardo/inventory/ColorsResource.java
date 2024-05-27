package com.inventory.leonardo.inventory;

import com.inventory.leonardo.inventory.model.Colors;
import com.inventory.leonardo.inventory.service.ColorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorsResource {
    private final ColorsService colorsService;

    public ColorsResource(ColorsService colorsService) {
        this.colorsService = colorsService;
    }

    // Get all colors
    @GetMapping("/all")
    public ResponseEntity<List<Colors>> getAllColors() {
        List<Colors> allColors = colorsService.findAllColors();
        return new ResponseEntity<>(allColors, HttpStatus.OK);
    }

    // Get color by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Colors> getColorById(@PathVariable("id") Integer id) {
        Colors color = colorsService.findColorById(id);
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    // Add new color
    @PostMapping("/add")
    public ResponseEntity<Colors> addColor(@RequestBody Colors color) {
        Colors newColor = colorsService.addColor(color);
        return new ResponseEntity<>(newColor, HttpStatus.CREATED);
    }

    // Update color
    @PutMapping("/update")
    public ResponseEntity<Colors> updateColor(@RequestBody Colors color) {
        Colors updateColor = colorsService.updateColor(color);
        return new ResponseEntity<>(updateColor, HttpStatus.OK);
    }

    // Delete color
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteColor(@PathVariable("id") Integer id) {
        colorsService.deleteColor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
