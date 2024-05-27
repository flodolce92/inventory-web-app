package com.inventory.leonardo.inventory;

import com.inventory.leonardo.inventory.model.Operations;
import com.inventory.leonardo.inventory.service.OperationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationsResource {
    private final OperationsService operationsService;

    public OperationsResource(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    // Get all operations
    @GetMapping("/all")
    public ResponseEntity<List<Operations>> getAllOperations() {
        List<Operations> allOperations = operationsService.findAllOperations();
        return new ResponseEntity<>(allOperations, HttpStatus.OK);
    }

    // Get operation by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Operations> getOperationById(@PathVariable("id") Integer id) {
        Operations operation = operationsService.findOperationById(id);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    // Add new operation
    @PostMapping("/add")
    public ResponseEntity<Operations> addOperation(@RequestBody Operations operation) {
        Operations newOperation = operationsService.addOperation(operation);
        return new ResponseEntity<>(newOperation, HttpStatus.CREATED);
    }

    // Update operation
    @PutMapping("/update")
    public ResponseEntity<Operations> updateOperation(@RequestBody Operations operation) {
        Operations updateOperation = operationsService.updateOperation(operation);
        return new ResponseEntity<>(updateOperation, HttpStatus.OK);
    }

    // Delete operation
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOperation(@PathVariable("id") Integer id) {
        operationsService.deleteOperation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
