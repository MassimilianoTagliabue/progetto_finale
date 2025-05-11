package org.lessons.java.progetto_finale.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.progetto_finale.model.Videogame;
import org.lessons.java.progetto_finale.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideogameService {
    
    
    @Autowired
    private VideogameRepository videogameRepository;

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
}
