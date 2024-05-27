package com.inventory.leonardo.inventory.service;

import com.inventory.leonardo.inventory.model.ListTransaction;
import com.inventory.leonardo.inventory.repo.ListTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTransactionService {
    private final ListTransactionRepo listTransactionRepo;

    @Autowired
    public ListTransactionService(ListTransactionRepo listTransactionRepo) {
        this.listTransactionRepo = listTransactionRepo;
    }

    public List<ListTransaction> findAllTransactions() {
        return listTransactionRepo.findAll();
    }

    public ListTransaction findTransactionById(Integer id) {
        return listTransactionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public ListTransaction addTransaction(ListTransaction transaction) {
        return listTransactionRepo.save(transaction);
    }

    public ListTransaction updateTransaction(ListTransaction transaction) {
        return listTransactionRepo.save(transaction);
    }

    public void deleteTransaction(Integer id) {
        listTransactionRepo.deleteById(id);
    }
}

