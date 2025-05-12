package org.lessons.java.progetto_finale.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.progetto_finale.model.Publisher;
import org.lessons.java.progetto_finale.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;
    

    public List<Publisher> findAll(){
        return publisherRepository.findAll();
    }

    public Publisher getById(Integer id){
        return publisherRepository.findById(id).get();
    }

    public Optional<Publisher> findById(Integer id){
        return publisherRepository.findById(id);
    }

    public List<Publisher> findByName(String name){
        return publisherRepository.findByNameContaining(name);
    }

    
}
