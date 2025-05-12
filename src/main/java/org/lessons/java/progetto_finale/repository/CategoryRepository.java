package org.lessons.java.progetto_finale.repository;

import java.util.List;

import org.lessons.java.progetto_finale.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
    public List<Category> findByNameContaining(String name);
}
