package com._shop.backend.model;

import jakarta.persistence.*;

//@Table(name = "categories")
@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int idCategory;
    private String name;

    public Categories(int idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                '}';
    }

}
