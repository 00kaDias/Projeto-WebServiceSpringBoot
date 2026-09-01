package com.kadias.demospringboot.services;

import com.kadias.demospringboot.entities.Category;
import com.kadias.demospringboot.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {
    private final CategoryRepository categoryRepository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findByID(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
