package com.example.ManyToOne.Project.repo;

import com.example.ManyToOne.Project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByCategoryId(int categoryId);
}
