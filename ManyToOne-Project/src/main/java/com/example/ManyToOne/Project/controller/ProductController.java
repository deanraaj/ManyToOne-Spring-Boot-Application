package com.example.ManyToOne.Project.controller;

import com.example.ManyToOne.Project.model.Product;
import com.example.ManyToOne.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/manytoone/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // add product
    @PostMapping(path = "/addProduct/{categoryId}")
    public ResponseEntity<Product> addProduct(@RequestBody Product product,@PathVariable int categoryId) {
        return productService.addProduct(product, categoryId);
    }

    // get products by Category
    @GetMapping(path = "/getProductsBycategory/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable int categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }

    // update product by Id;
    @PutMapping(path = "/updateProduct/{id}")
    public ResponseEntity<Product> updateProductById(@RequestBody Product product, @PathVariable int id) {
        return productService.updateProductById(product, id);
    }

    @DeleteMapping(path = "/deleteProduct/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id) {
        return productService.deleteProductById(id);
    }

}

