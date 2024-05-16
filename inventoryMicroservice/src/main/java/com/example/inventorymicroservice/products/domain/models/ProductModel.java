package com.example.inventorymicroservice.products.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductModel {
    private UUID id;
    private String name;
    private Float price;
    private String currency;
}
