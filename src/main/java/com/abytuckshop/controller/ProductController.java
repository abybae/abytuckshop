package com.abytuckshop.controller;

import com.abytuckshop.entity.Product;
import com.abytuckshop.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable long id){
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid product id %s", id)));
    }

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product createProduct(@Valid @RequestBody Product themeParkRide) {
        return productRepository.save(themeParkRide);
    }
}
