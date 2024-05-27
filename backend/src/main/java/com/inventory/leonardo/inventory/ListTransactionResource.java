package com.inventory.leonardo.inventory;

import com.inventory.leonardo.inventory.model.ListTransaction;
import com.inventory.leonardo.inventory.service.ListTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class ListTransactionResource {
    private final ListTransactionService listTransactionService;

    public ListTransactionResource(ListTransactionService listTransactionService) {
        this.listTransactionService = listTransactionService;
    }

    // Get all transactions
    @GetMapping("/all")
    public ResponseEntity<List<ListTransaction>> getAllTransactions() {
        List<ListTransaction> allTransactions = listTransactionService.findAllTransactions();
        return new ResponseEntity<>(allTransactions, HttpStatus.OK);
    }

    // Get transaction by id
    @GetMapping("/find/{id}")
    public ResponseEntity<ListTransaction> getTransactionById(@PathVariable("id") Integer id) {
        ListTransaction transaction = listTransactionService.findTransactionById(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    // Add new transaction
    @PostMapping("/add")
    public ResponseEntity<ListTransaction> addTransaction(@RequestBody ListTransaction transaction) {
        ListTransaction newTransaction = listTransactionService.addTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    // Update transaction
    @PutMapping("/update")
    public ResponseEntity<ListTransaction> updateTransaction(@RequestBody ListTransaction transaction) {
        ListTransaction updateTransaction = listTransactionService.updateTransaction(transaction);
        return new ResponseEntity<>(updateTransaction, HttpStatus.OK);
    }

    // Delete transaction
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable("id") Integer id) {
        listTransactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
