package org.lessons.java.progetto_finale.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.progetto_finale.model.Category;
import org.lessons.java.progetto_finale.model.Publisher;
import org.lessons.java.progetto_finale.model.Videogame;
import org.lessons.java.progetto_finale.repository.CategoryRepository;
import org.lessons.java.progetto_finale.repository.PublisherRepository;
import org.lessons.java.progetto_finale.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideogameService {
    
    
    @Autowired
    private VideogameRepository videogameRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired 
    private PublisherRepository publisherRepository;

    public List<Videogame> findAll(){
        return videogameRepository.findAll();
    }

    public List<Videogame> findByTitle(String title){
        return videogameRepository.findByTitleContaining(title);
    }

    public Videogame getById(Integer id){
        return videogameRepository.findById(id).get();
    }

    public Optional<Videogame> findById(Integer id){
        return videogameRepository.findById(id);
    }

    public Videogame createOrEdit(Videogame formVideogame){
        return videogameRepository.save(formVideogame);
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public List<Publisher> findAllPublishers(){
        return publisherRepository.findAll();
    }

    public void deleteById(Integer id){
        Videogame videogameToDelete = getById(id);

        videogameRepository.delete(videogameToDelete);
    }
}
