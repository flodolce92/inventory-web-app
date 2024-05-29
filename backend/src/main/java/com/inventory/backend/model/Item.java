package com.inventory.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private String category;

    @NotEmpty(message = "price cannot be empty")
    private double price;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemOption> options;
}
