package com.example.crud.controllers;

import com.example.crud.domain.product.Category;
import com.example.crud.domain.product.CategoryRepository;
import com.example.crud.domain.product.RequestCategoryDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping
    public ResponseEntity getAllCategories(){
        var allCategories = repository.findAll();
        return ResponseEntity.ok(allCategories);
    }

    @PostMapping
    public ResponseEntity registerCategory(@RequestBody @Valid RequestCategoryDTO data){
        Category newCategory = new Category(data);
        repository.save(newCategory);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid RequestCategoryDTO data){
        Optional<Category> optionalCategory = repository.findById(data.id());
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setName(data.name());
            return ResponseEntity.ok(category);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCategory(@PathVariable String id){
        Optional<Category> optionalCategory = repository.findById(id);
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setActive(false);
            return ResponseEntity.ok(category);
        } else {
            throw new EntityNotFoundException();
        }
    }
}