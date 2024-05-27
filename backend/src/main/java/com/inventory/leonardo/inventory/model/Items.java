package com.inventory.leonardo.inventory.model;

import jakarta.persistence.*;

@Entity
//@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private int fkdIdCategory;
    private int fkIdColor;
    private int fkIdSize;

    public Items(int id, String name, String description, double price, int quantity, int fkdIdCategory, int fkIdColor, int fkIdSize) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.fkdIdCategory = fkdIdCategory;
        this.fkIdColor = fkIdColor;
        this.fkIdSize = fkIdSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFkdIdCategory() {
        return fkdIdCategory;
    }

    public void setFkdIdCategory(int fkdIdCategory) {
        this.fkdIdCategory = fkdIdCategory;
    }

    public int getFkIdColor() {
        return fkIdColor;
    }

    public void setFkIdColor(int fkIdColor) {
        this.fkIdColor = fkIdColor;
    }

    public int getFkIdSize() {
        return fkIdSize;
    }

    public void setFkIdSize(int fkIdSize) {
        this.fkIdSize = fkIdSize;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", fkdIdCategory=" + fkdIdCategory +
                ", fkIdColor=" + fkIdColor +
                ", fkIdSize=" + fkIdSize +
                '}';
    }

}
