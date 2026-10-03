package com.project.ecommerce_backend.service;

import com.project.ecommerce_backend.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category saveCategory(Category category);
    public List<Category> getAllCategories();
    public Category getCategoryById(int id);
    public void deleteCategory(int id);
}
