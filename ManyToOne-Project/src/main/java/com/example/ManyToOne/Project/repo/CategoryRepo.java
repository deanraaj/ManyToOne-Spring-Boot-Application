package com.example.ManyToOne.Project.repo;

import com.example.ManyToOne.Project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
