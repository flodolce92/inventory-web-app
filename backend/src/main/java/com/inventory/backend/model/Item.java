package com.inventory.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "name cannot be empty")
    private String name;
    private String description;
    @NotEmpty(message = "price cannot be empty")
    private double price;
    private int quantity;
    private int fkIdCategory;
    private int fkIdSize;

    @ManyToOne
    @JoinColumn(name = "fkIdColor")
    private Color color;
}
