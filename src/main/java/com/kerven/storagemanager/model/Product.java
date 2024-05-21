package com.kerven.storagemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome precisa ser informado")
    private String name;

    @NotNull(message = "A descricao precisa ser informada")
    private String description;

    @NotNull(message = "O valor precisa ser informado")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que 0.01")
    private double price;

    @NotNull(message = "A quantidade precisa ser informada")
    private int quantity;
}
