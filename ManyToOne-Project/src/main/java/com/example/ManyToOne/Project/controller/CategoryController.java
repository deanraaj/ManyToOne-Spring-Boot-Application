package com.example.ManyToOne.Project.controller;

import com.example.ManyToOne.Project.model.Category;
import com.example.ManyToOne.Project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // add category
    @PostMapping(path = "/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    // get all category
    @GetMapping(path = "/getCategories")
    public ResponseEntity<List<Category>> getCategories() {
        return categoryService.getCategories();
    }



}
