package com.inventory.leonardo.inventory.model;

import jakarta.persistence.*;

@Entity
//@Table(name = "sizes")
public class Sizes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int idSize;
    private String name;

    public Sizes(int idSize, String name) {
        this.idSize = idSize;
        this.name = name;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sizes{" +
                "idSize=" + idSize +
                ", name='" + name + '\'' +
                '}';
    }

}
