package com.example.inventorymicroservice.products.application.services;

import com.example.inventorymicroservice.products.application.ports.inputs.IProductServicePort;
import com.example.inventorymicroservice.products.application.ports.outputs.IProductPersistencePort;
import com.example.inventorymicroservice.products.domain.models.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements IProductServicePort {
    private final IProductPersistencePort persistencePort;

    public ProductServiceImpl(IProductPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public List<ProductModel> list() {
        return persistencePort.list();
    }

    @Override
    public ProductModel create(ProductModel product) {
        return persistencePort.create(product);
    }

    @Override
    public void delete(UUID id) {
        persistencePort.delete(id);
    }


}
