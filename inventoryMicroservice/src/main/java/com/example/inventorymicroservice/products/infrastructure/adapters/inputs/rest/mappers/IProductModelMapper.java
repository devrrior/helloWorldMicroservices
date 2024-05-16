package com.example.inventorymicroservice.products.infrastructure.adapters.inputs.rest.mappers;

import com.example.inventorymicroservice.products.domain.models.ProductModel;
import com.example.inventorymicroservice.products.infrastructure.adapters.inputs.rest.dtos.requests.CreateProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IProductModelMapper {
    ProductModel toProductModel(CreateProductRequest request);
}
