package com.project.ecommerce_backend.controller;

import com.project.ecommerce_backend.entity.Product;
import com.project.ecommerce_backend.exception.ProductException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.ecommerce_backend.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = null;
       try {
           savedProduct = productService.saveProduct(product);
       }catch (ProductException pEx){
           pEx.printStackTrace();
       }
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductsList(){
        List<Product> listOfProducts = productService.getAllProducts();
        return ResponseEntity.ok(listOfProducts);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
