package com.inventory.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemOption {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_id_item")
    @JsonBackReference
    private Item item;

    private String size;

    private String color;

    private int quantity;

    @JsonProperty("id_item")
    public Long getItemId() {
        if (item != null) {
            return item.getId();
        }
        return null;
    }
}
