package com.project.ecommerce_backend.service;

import com.project.ecommerce_backend.entity.Product;
import com.project.ecommerce_backend.exception.ProductException;
import org.springframework.stereotype.Service;
import com.project.ecommerce_backend.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImplementation(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) throws ProductException {
        if(product.getPrice() < 1){
            throw new  ProductException("price must be greater than zero");
        }
        if(product.getStockQuantity() < 1){
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

    public Product getProductById(int id){
        return productRepository.getById(id);
    }
}
