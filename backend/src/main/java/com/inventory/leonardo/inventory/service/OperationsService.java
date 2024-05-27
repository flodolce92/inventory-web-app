package com.inventory.leonardo.inventory.service;

import com.inventory.leonardo.inventory.model.Operations;
import com.inventory.leonardo.inventory.repo.OperationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationsService {
    private final OperationsRepo operationsRepo;

    @Autowired
    public OperationsService(OperationsRepo operationsRepo) {
        this.operationsRepo = operationsRepo;
    }

    public List<Operations> findAllOperations() {
        return operationsRepo.findAll();
    }

    public Operations findOperationById(Integer id) {
        return operationsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Operation not found"));
    }

    public Operations addOperation(Operations operation) {
        return operationsRepo.save(operation);
    }

    public Operations updateOperation(Operations operation) {
        return operationsRepo.save(operation);
    }

    public void deleteOperation(Integer id) {
        operationsRepo.deleteById(id);
    }
}
