package com.example.inventorymicroservice.products.infrastructure.adapters.inputs.rest.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateProductRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 0, message = "Price must be greater than 0")
    private Float price;

    @NotBlank(message = "Description is required")
    private String currency;
}
