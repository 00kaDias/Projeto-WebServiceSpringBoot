package com.kadias.demospringboot.services;

import com.kadias.demospringboot.entities.Product;
import com.kadias.demospringboot.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    private final ProductRepository productRepository;

    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByID(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
}
