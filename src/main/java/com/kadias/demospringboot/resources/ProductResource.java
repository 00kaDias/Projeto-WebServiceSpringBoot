package com.kadias.demospringboot.resources;

import com.kadias.demospringboot.entities.Product;
import com.kadias.demospringboot.services.ProductServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    private final ProductServices productServices;

    public ProductResource(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productServices.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productServices.findByID(id);
        return ResponseEntity.ok().body(product);

    }
}