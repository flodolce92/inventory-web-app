package com.inventory.leonardo.inventory.model;

import jakarta.persistence.*;

@Entity
//@Table(name = "colors")
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int idColor;
    private String name;

    public Colors(int idColor, String name) {
        this.idColor = idColor;
        this.name = name;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Colors{" +
                "idColor=" + idColor +
                ", name='" + name + '\'' +
                '}';
    }

}
