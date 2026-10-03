package com.project.ecommerce_backend.service;

import com.project.ecommerce_backend.entity.Product;
import com.project.ecommerce_backend.exception.ProductException;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product) throws ProductException;
    public List<Product> getAllProducts();
    public void deleteProduct(int id);
    public Product getProductById(int id);
}
