package com.project.ecommerce_backend.service;

import com.project.ecommerce_backend.entity.Product;
import com.project.ecommerce_backend.exception.ProductException;
import org.springframework.stereotype.Service;
import com.project.ecommerce_backend.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) throws ProductException {
        if(product.price < 1){
            throw new  ProductException("price must be greater than zero");
        }
        if(product.stockQuantity < 1){
            throw new ProductException("stock quantity must be 1 or more than one");
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
