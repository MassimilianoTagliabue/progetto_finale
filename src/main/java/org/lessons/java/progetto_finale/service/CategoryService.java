package org.lessons.java.progetto_finale.service;

import java.util.List;

import org.lessons.java.progetto_finale.model.Category;
import org.lessons.java.progetto_finale.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category getById(Integer id){
        return categoryRepository.findById(id).get();
    }
}
