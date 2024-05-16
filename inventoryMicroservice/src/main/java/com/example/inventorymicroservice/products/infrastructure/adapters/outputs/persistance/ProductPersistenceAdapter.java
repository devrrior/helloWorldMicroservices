package com.example.inventorymicroservice.products.infrastructure.adapters.outputs.persistance;

import com.example.inventorymicroservice.products.application.ports.outputs.IProductPersistencePort;
import com.example.inventorymicroservice.products.domain.models.ProductModel;
import com.example.inventorymicroservice.products.infrastructure.adapters.outputs.persistance.entities.ProductEntity;
import com.example.inventorymicroservice.products.infrastructure.adapters.outputs.persistance.mappers.IProductEntityMapper;
import com.example.inventorymicroservice.products.infrastructure.adapters.outputs.persistance.repositories.IProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductPersistenceAdapter implements IProductPersistencePort {
    private final IProductRepository repository;
    private final IProductEntityMapper mapper;

    public ProductPersistenceAdapter(IProductRepository repository, IProductEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductModel> list() {
        return repository.findAll().stream().map(mapper::toProductModel).toList();
    }

    @Override
    public ProductModel create(ProductModel product) {
        ProductEntity entity = mapper.toProductEntity(product);
        ProductEntity createdEntity = repository.save(entity);

        return mapper.toProductModel(createdEntity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
