package org.lessons.java.progetto_finale.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.progetto_finale.model.Category;
import org.lessons.java.progetto_finale.model.Videogame;
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

    public List<Category> findByName(String name){
        return categoryRepository.findByNameContaining(name);
    }


    public Category getById(Integer id){
        return categoryRepository.findById(id).get();
    }

    public Optional<Category> findById(Integer id){
        return categoryRepository.findById(id);
    }

    public Category createOrUpdate(Category formCategory){
        return categoryRepository.save(formCategory);
    }

    public void deleteById(Integer id){
        Category categoryToDelete = getById(id);        //categoria da cancellare

        for (Videogame linkedVideogame : categoryToDelete.getVideogames()) {    //ciclo tutti i videogiochi collegati
            linkedVideogame.getCategories().remove(categoryToDelete);           //rimuovo la categoria
        }

        categoryRepository.deleteById(id);
    }
}
