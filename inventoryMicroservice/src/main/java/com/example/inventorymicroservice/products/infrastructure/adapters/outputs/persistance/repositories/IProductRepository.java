package com.example.inventorymicroservice.products.infrastructure.adapters.outputs.persistance.repositories;

import com.example.inventorymicroservice.products.infrastructure.adapters.outputs.persistance.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, UUID> {

}
