package com.example.inventorymicroservice.products.infrastructure.adapters.inputs.rest;

import com.example.inventorymicroservice.products.application.ports.inputs.IProductServicePort;
import com.example.inventorymicroservice.products.domain.models.ProductModel;
import com.example.inventorymicroservice.products.infrastructure.adapters.inputs.rest.dtos.requests.CreateProductRequest;
import com.example.inventorymicroservice.products.infrastructure.adapters.inputs.rest.mappers.IProductModelMapper;
import com.example.inventorymicroservice.shared.infrastructure.adapters.inputs.rest.dtos.responses.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductRestAdapter {
    private final IProductServicePort servicePort;
    private final IProductModelMapper mapper;

    public ProductRestAdapter(IProductServicePort servicePort, IProductModelMapper mapper) {
        this.servicePort = servicePort;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> list() {
        List<ProductModel> products = servicePort.list();

        BaseResponse response = BaseResponse.builder()
                .data(products)
                .message("Products listed successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();

        return response.toResponseEntity();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody CreateProductRequest request) {
        ProductModel product = servicePort.create(mapper.toProductModel(request));

        BaseResponse response = BaseResponse.builder()
                .data(product)
                .message("Product created successfully")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();

        return response.toResponseEntity();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable UUID id) {
        servicePort.delete(id);

        BaseResponse response = BaseResponse.builder()
                .message("Product deleted successfully")
                .success(true)
                .httpStatus(HttpStatus.NO_CONTENT)
                .build();

        return response.toResponseEntity();
    }
}
