package com.kadias.demospringboot.resources;

import com.kadias.demospringboot.entities.Category;
import com.kadias.demospringboot.services.CategoryServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    private final CategoryServices categoryServices;

    public CategoryResource(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categorys = categoryServices.findAll();
        return ResponseEntity.ok().body(categorys);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryServices.findByID(id);
        return ResponseEntity.ok().body(category);

    }
}