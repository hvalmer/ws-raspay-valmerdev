package com.rasmoo.client.raspay.controller.impl;

import com.rasmoo.client.raspay.controller.ProductController;
import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.ProductModel;
import com.rasmoo.client.raspay.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Override
    public ResponseEntity<ProductModel> create(@Valid @RequestBody ProductDto dto) {
        ProductModel created = productService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProductModel>> readAll() {
        List<ProductModel> products = productService.readAll();
        return ResponseEntity.ok(products);
    }
}
