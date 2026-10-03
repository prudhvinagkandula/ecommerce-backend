package com.project.ecommerce_backend.controller;

import com.project.ecommerce_backend.entity.Category;
import com.project.ecommerce_backend.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<Category> registerCategory(Category category){

        Category savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> categoriesList(){
        List<Category> listOfCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(listOfCategories);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> categoryById(@PathVariable int id){
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
