package com.example.inventorymicroservice.products.application.ports.outputs;

import com.example.inventorymicroservice.products.domain.models.ProductModel;

import java.util.List;
import java.util.UUID;

public interface IProductPersistencePort {
    List<ProductModel> list();
    ProductModel create(ProductModel product);
    void delete(UUID id);
}
