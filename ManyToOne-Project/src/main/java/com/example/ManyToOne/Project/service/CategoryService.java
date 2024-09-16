package com.example.ManyToOne.Project.service;

import com.example.ManyToOne.Project.model.Category;
import com.example.ManyToOne.Project.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    // add category
    public ResponseEntity<Category> addCategory(Category category) {
        categoryRepo.save(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepo.save(category));
    }

    // get all category
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepo.findAll());
    }


}
