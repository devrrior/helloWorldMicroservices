package com.example.inventorymicroservice.products.infrastructure.adapters.outputs.persistance.mappers;

import com.example.inventorymicroservice.products.domain.models.ProductModel;
import com.example.inventorymicroservice.products.infrastructure.adapters.outputs.persistance.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductEntityMapper {
    ProductModel toProductModel(ProductEntity productEntity);
    ProductEntity toProductEntity(ProductModel productModel);
}