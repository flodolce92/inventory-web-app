package com.inventory.leonardo.inventory;

import com.inventory.leonardo.inventory.model.Sizes;
import com.inventory.leonardo.inventory.service.SizesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/size")
public class SizesResource {
    private final SizesService sizesService;

    public SizesResource(SizesService sizesService) {
        this.sizesService = sizesService;
    }

    // Get all sizes
    @GetMapping("/all")
    public ResponseEntity<List<Sizes>> getAllSizes() {
        List<Sizes> allSizes = sizesService.findAllSizes();
        return new ResponseEntity<>(allSizes, HttpStatus.OK);
    }

    // Get size by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Sizes> getSizeById(@PathVariable("id") Integer id) {
        Sizes size = sizesService.findSizeById(id);
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    // Add new size
    @PostMapping("/add")
    public ResponseEntity<Sizes> addSize(@RequestBody Sizes size) {
        Sizes newSize = sizesService.addSize(size);
        return new ResponseEntity<>(newSize, HttpStatus.CREATED);
    }

    // Update size
    @PutMapping("/update")
    public ResponseEntity<Sizes> updateSize(@RequestBody Sizes size) {
        Sizes updateSize = sizesService.updateSize(size);
        return new ResponseEntity<>(updateSize, HttpStatus.OK);
    }

    // Delete size
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSize(@PathVariable("id") Integer id) {
        sizesService.deleteSize(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
