package com.inventory.leonardo.inventory.model;

import jakarta.persistence.*;

@Entity
//@Table(name = "operations")
public class Operations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int idOperation;
    private String name;

    public Operations(int idOperation, String name) {
        this.idOperation = idOperation;
        this.name = name;
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "idOperation=" + idOperation +
                ", name='" + name + '\'' +
                '}';
    }

}
