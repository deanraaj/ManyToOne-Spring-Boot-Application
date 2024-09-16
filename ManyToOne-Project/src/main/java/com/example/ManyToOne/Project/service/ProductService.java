package com.example.ManyToOne.Project.service;

import com.example.ManyToOne.Project.customException.CategoryNotFoundException;
import com.example.ManyToOne.Project.customException.ProductNotFoundException;
import com.example.ManyToOne.Project.model.Category;
import com.example.ManyToOne.Project.model.Product;
import com.example.ManyToOne.Project.repo.CategoryRepo;
import com.example.ManyToOne.Project.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    // add product
    public ResponseEntity<Product> addProduct(Product product, int categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Not found"));
        product.setCategory(category);

        Product savedProduct = productRepo.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    // GET /api/products/category/{categoryId}
    public ResponseEntity<List<Product>> getProductsByCategoryId(int categoryId) {
        if(categoryRepo.existsById(categoryId) == false) {
            throw new CategoryNotFoundException("Category not found.. Broooo");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productRepo.findByCategoryId(categoryId));
    }

    // update product by id
    public ResponseEntity<Product> updateProductById(Product product, int id) {
        Product product1 = productRepo.findById(id).
                orElseThrow(() -> new ProductNotFoundException("Product not found, can't be updated.."));

        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());

        Product updatedProduct = productRepo.save(product1);

        return ResponseEntity.status(HttpStatus.CREATED).body(updatedProduct);
    }

    // delete product by id
    public ResponseEntity<String> deleteProductById(int id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found, can't be deleted..."));
        productRepo.delete(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product has been deleted succssfully..!");
    }
}
