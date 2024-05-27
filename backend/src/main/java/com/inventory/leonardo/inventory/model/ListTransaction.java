package com.inventory.leonardo.inventory.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "listTransactions")
public class ListTransaction {
    // questi tag servono per la chiave della tabella
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int idTransaction;
    private Date date;
    private int quantityTransaction;
    private double priceTransaction;
    private int fkIdItem;
    private int fkIdOperation;

    public ListTransaction(int idTransaction, Date date, int quantityTransaction, double priceTransaction, int fkIdItem, int fkIdOperation) {
        this.idTransaction = idTransaction;
        this.date = date;
        this.quantityTransaction = quantityTransaction;
        this.priceTransaction = priceTransaction;
        this.fkIdItem = fkIdItem;
        this.fkIdOperation = fkIdOperation;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantityTransaction() {
        return quantityTransaction;
    }

    public void setQuantityTransaction(int quantityTransaction) {
        this.quantityTransaction = quantityTransaction;
    }

    public double getPriceTransaction() {
        return priceTransaction;
    }

    public void setPriceTransaction(double priceTransaction) {
        this.priceTransaction = priceTransaction;
    }

    public int getFkIdItem() {
        return fkIdItem;
    }

    public void setFkIdItem(int fkIdItem) {
        this.fkIdItem = fkIdItem;
    }

    public int getFkIdOperation() {
        return fkIdOperation;
    }

    public void setFkIdOperation(int fkIdOperation) {
        this.fkIdOperation = fkIdOperation;
    }

    @Override
    public String toString() {
        return "ListTransaction{" +
                "idTransaction=" + idTransaction +
                ", date=" + date +
                ", quantityTransaction=" + quantityTransaction +
                ", priceTransaction=" + priceTransaction +
                ", fkIdItem=" + fkIdItem +
                ", fkIdOperation=" + fkIdOperation +
                '}';
    }

}
